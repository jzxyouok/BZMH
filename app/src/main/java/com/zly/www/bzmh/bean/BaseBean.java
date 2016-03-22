package com.zly.www.bzmh.bean;

/**
 * Author: zhuliyuan
 * Time: 下午 3:23
 */

public class BaseBean {
    public String message;
    public String error;


    /**
     * 返回数据是否正常
     *
     * @return
     */
    public boolean isSuccess() {
        return error.equals("-1") ? true : false;
    }

    /**
     * 返回提示
     *
     * @return
     */
    public String getResultMsg() {
        String msg = "";
        switch (error) {
            case "":

                break;
        }
        return msg;
    }
}
