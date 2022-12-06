package ec.edu.espe.gpr.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import ec.edu.espe.gpr.message.FileMessage;
import ec.edu.espe.gpr.model.FileModel;
import ec.edu.espe.gpr.services.FileService;

@Controller
@CrossOrigin("*")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileMessage> uploadFiles(@RequestParam("file")MultipartFile file){
        String message = "";
        try{
            fileService.save(file);
            message = "Se subieron los archivos correctamente ";
            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        }catch (Exception e){
            message = "Fallo al subir los archivos";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileModel>> getFiles(){
        List<FileModel> fileInfos = fileService.loadAll().map(path -> {
          String filename = path.getFileName().toString();
          String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile",
                  path.getFileName().toString()).build().toString();
                  System.out.println(url);
                  return new FileModel(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename() + "\"").body(file);
    }

    @GetMapping("/delete/{filename:.+}")
    public ResponseEntity<FileMessage> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = fileService.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }

}