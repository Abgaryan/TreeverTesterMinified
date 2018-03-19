package com.treever_template_tester.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abgaryan on 3/18/18.
 */

public class ServerResponseModel {
    private int status ;
    private int  err_code;


    @SerializedName("data")
    private ServerDataModel serverDataModel;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public ServerDataModel getServerDataModel() {
        return serverDataModel;
    }

    public void setServerDataModel(ServerDataModel serverDataModel) {
        this.serverDataModel = serverDataModel;
    }
}
