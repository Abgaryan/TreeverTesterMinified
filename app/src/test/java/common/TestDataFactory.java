package common;

import com.treever_template_tester.model.ModelBackgroundImage;
import com.treever_template_tester.model.ModelMusic;
import com.treever_template_tester.model.ModelQuote;
import com.treever_template_tester.model.ModelTemplate;
import com.treever_template_tester.model.ModelTopic;
import com.treever_template_tester.model.ServerDataModel;
import com.treever_template_tester.model.ServerResponseModel;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Abgaryan on 3/18/18.
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */

public class TestDataFactory {
    public static String randomString() {
        return UUID.randomUUID().toString();
    }



    public static ServerResponseModel makeSereverResponesModel() {
        ServerResponseModel serverResponseModel = new ServerResponseModel();
        serverResponseModel.setStatus(1);
        serverResponseModel.setErr_code(0);


        ServerDataModel serverDataModel = new ServerDataModel();

        serverDataModel.setModelTemplates( makeListTemplates(25));
        serverDataModel.setModelBackgroundImages(new ArrayList<ModelBackgroundImage>());
        serverDataModel.setModelMusics(new ArrayList<ModelMusic>());
        serverDataModel.setModelQuotes(new ArrayList<ModelQuote>());
        serverDataModel.setModelTopics(new ArrayList<ModelTopic>());
        serverDataModel.setTimestamp(0);

        serverResponseModel.setServerDataModel(serverDataModel);
        return serverResponseModel;
    }

        public static ArrayList<ModelTemplate> makeListTemplates(int size) {
            ArrayList<ModelTemplate> templateList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                templateList.add(makeModelTemplateToBeTested(i));
                templateList.add(makeModelTemplateReviewed(i));
            }
            return templateList;
        }






    public static ModelTemplate makeModelTemplateToBeTested(int id){
        ModelTemplate modelTemplateToBeTested = new ModelTemplate();
        modelTemplateToBeTested.setFile_name(randomString());
        modelTemplateToBeTested.setStatus(1);
        modelTemplateToBeTested.setMood("2");
        modelTemplateToBeTested.setTemplate_body("HTTP");
        modelTemplateToBeTested.setImage_count(3);
        modelTemplateToBeTested.setTemplate_cloud_id(id);

       return  modelTemplateToBeTested;
    }


    public static ModelTemplate makeModelTemplateReviewed(int id){

        ModelTemplate modelTemplateReviewed = new ModelTemplate();
        modelTemplateReviewed.setFile_name(randomString());
        modelTemplateReviewed.setStatus(2);
        modelTemplateReviewed.setMood("4");
        modelTemplateReviewed.setTemplate_body("HTTP");
        modelTemplateReviewed.setImage_count(3);
        modelTemplateReviewed.setTemplate_cloud_id(10*id);
        return  modelTemplateReviewed;

    }
}
