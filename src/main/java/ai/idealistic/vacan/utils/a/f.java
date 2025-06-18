package ai.idealistic.vacan.utils.a;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import lombok.Generated;

public final class f {
   public static final int ke = 30000;

   public static String[] a(String var0, String var1, String var2, int var3) {
      boolean var4 = var1.equals("POST");
      String[] var5 = var0.split(" ");
      URL var6 = new URL(var5[0]);
      HttpsURLConnection var7 = (HttpsURLConnection)var6.openConnection();
      var7.addRequestProperty("User-Agent", ai.idealistic.vacan.functionality.connection.e.eN() + (var2 != null ? " (" + var2 + ")" : ""));
      var7.setRequestMethod(var1);
      var7.setReadTimeout(var3);
      var7.setDoOutput(true);
      var7.connect();
      if (var4 && var5.length > 1) {
         DataOutputStream var8 = new DataOutputStream(var7.getOutputStream());
         var8.writeBytes(var5[1]);
         var8.flush();
         var8.close();
      }

      BufferedReader var11 = new BufferedReader(new InputStreamReader(var7.getInputStream()));
      ArrayList var9 = new ArrayList(50);

      String var10;
      while((var10 = var11.readLine()) != null) {
         var9.add(var10);
      }

      var11.close();
      return (String[])var9.toArray(new String[0]);
   }

   public static String[] c(String var0, String var1) {
      return a(var0, var1, (String)null, 30000);
   }

   public static String[] h(String var0, int var1) {
      return a(var0, "GET", (String)null, var1);
   }

   public static String[] ab(String var0) {
      return a(var0, "GET", (String)null, 30000);
   }

   @Generated
   private f() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
