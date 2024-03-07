package controllers;
import etu1789.framework.annotation.AnnotationScop;
import etu1789.framework.annotation.AnnotationUrl;
import etu1789.framework.annotation.FromBody;
import etu1789.framework.annotation.FromHeader;
import etu1789.framework.annotation.FromUrl;
import etu1789.framework.annotation.RestApi;
import etu1789.framework.upload.FileUpload;
import etu1789.dao.connexion.Connexion_projet;
import java.sql.Connection;
import models.Commandes;
import etu1789.framework.response.ResponseREST;

@AnnotationScop(scop = "singleton")

public class CommandesController {
    private Connexion_projet dao=new Connexion_projet("daotest", "localhost", "5432", "postgres", "Hasinjo2");

    
    @RestApi(method = "POST", params = true)
@AnnotationUrl(url = "commandes")
public ResponseREST insert(@FromBody Commandes entity) throws Exception{
    ResponseREST response = new ResponseREST();
    Connection connex=dao.getconnection();
    try{
        entity.create(connex);
        response.setMessage("save success");
        connex.commit();
    }catch (Exception e) {
        connex.rollback();
        response.setMessage(e.getMessage());
    }finally{
        connex.close();
    }
    return response;
}
@RestApi(method = "GET", params = false)
@AnnotationUrl(url = "commandes")
public ResponseREST crudpage() throws Exception{
    ResponseREST response = new ResponseREST();
    Commandes obj = new Commandes();
    Connection connex=dao.getconnection();
    try{
       response.setData(obj.findAll(connex));
        response.setMessage("success");
    }catch (Exception e) {
        response.setMessage(e.getMessage());
    }finally{
        connex.close();
    }
    return response;
}
@RestApi(method = "PUT", params = true)
@AnnotationUrl(url = "commandes")
public ResponseREST update(int id, @FromBody Commandes entity) throws Exception{
    ResponseREST response = new ResponseREST();
    Commandes where=new Commandes(id);
    Connection connex=dao.getconnection();
    try{
        where.update(connex, entity);
        response.setMessage("update success");
        connex.commit();
    }catch (Exception e) {
        connex.rollback();
        response.setMessage(e.getMessage());
    }finally{
        connex.close();
    }
    return response;
}
@RestApi(method = "DELETE", params = true)
@AnnotationUrl(url = "commandes")
public ResponseREST delete(int id) throws Exception{
    ResponseREST response = new ResponseREST();
    Connection connex=dao.getconnection();
    try{
        Commandes where=new Commandes(id);
        where.delete(connex);
        response.setMessage("update success");
        connex.commit();
    }catch (Exception e) {
        connex.rollback();
        response.setMessage(e.getMessage());
    }finally{
        connex.close();
    }
    return response;
}

}

