package com.newtouch.fbb.mulithread.thread;

import com.google.gson.Gson;

import java.io.*;

/**
 * Created by steven on 2018/1/10.
 */
public class DataThread extends Thread {

    File file;

    public DataThread(File file){
        this.file=file;
    }

    public void run(){
        doBusiness2();
    }

    private void doBusiness1(){
        try(FileReader fr=new FileReader(file);BufferedReader reader = new BufferedReader(fr);){
            String context=null;
            byte mark_1=(byte)1;
            while((context=reader.readLine())!=null){
                DataHandler.getByte(context,mark_1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doBusiness2(){
        createFile();
        sendToES();
    }
    private void sendToES(){
        String cmdstring="sh /Users/steven/mywork/fileTest/esTest/test.sh "+file.getAbsolutePath();
        BufferedReader in=null;
        InputStreamReader inputStreamReader=null;
        InputStream inputStream=null;
        try{
            Process process=Runtime.getRuntime().exec(cmdstring);
            inputStream=process.getInputStream();
            inputStreamReader=new InputStreamReader(inputStream);
            in = new BufferedReader(inputStreamReader);
            String s = "";
            while ((s = in.readLine()) != null) {
                //System.out.println(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createFile(){
        StringBuffer sb = new StringBuffer();
        Gson gson = new Gson();
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);){
            int a=1;
            for(int j=0;j<100000;j++){
                a=a+1;
                sb.append("{\"index\":{\"_index\":\"test\",\"_type\":\"testdata\"}}").append("\n");
                sb.append("{\"code \":" + System.currentTimeMillis() + ",\"message\":" + "\"succ\"" + "}").append("\n");
                if(a>1000){

                    fileOutputStream.write(sb.toString().getBytes());
                    fileOutputStream.flush();
                    sb=new StringBuffer();;
                    a=1;
                }
            }
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.flush();
        }catch(IOException e){

        }
    }



}
