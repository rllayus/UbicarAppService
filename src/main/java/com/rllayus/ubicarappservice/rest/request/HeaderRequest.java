package com.rllayus.ubicarappservice.rest.request;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
public class HeaderRequest implements Serializable {
   private String ime;
   private String jsessionid;
   private String appName;
   private String eh;
   private String user;

   public String getIme() {
      return ime;
   }

   public void setIme(String ime) {
      this.ime = ime;
   }

   public String getJsessionid() {
      return jsessionid;
   }

   public void setJsessionid(String jsessionid) {
      this.jsessionid = jsessionid;
   }

   public String getAppName() {
      return appName;
   }

   public void setAppName(String appName) {
      this.appName = appName;
   }

   public String getEh() {
      return eh;
   }

   public void setEh(String eh) {
      this.eh = eh;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }
}
