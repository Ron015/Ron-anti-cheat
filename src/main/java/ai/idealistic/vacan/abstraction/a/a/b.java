package ai.idealistic.vacan.abstraction.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.api.VacanAPI;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.a.g;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Material;

public class b extends ai.idealistic.vacan.abstraction.a.a {
   private static final ai.idealistic.vacan.functionality.b.b.a eI = new ai.idealistic.vacan.functionality.b.b.a(50L);
   private static boolean enabled = false;
   private static Connection eJ = null;

   public b() {
      super("sql");
   }

   public String az() {
      String var1 = this.l("host");
      if (var1 != null) {
         var1 = var1.toLowerCase().replace("localhost", "127.0.0.1").replace(" ", "");
      }

      return var1;
   }

   public String aA() {
      String var1 = this.l("user");
      if (var1 != null) {
         var1 = var1.replace(" ", "");
      }

      return var1;
   }

   public String aB() {
      String var1 = this.l("password");
      if (var1 != null && this.i("escape_special_characters")) {
         var1 = g.aj(var1);
      }

      return var1;
   }

   public String aC() {
      String var1 = this.l("database");
      if (var1 != null) {
         var1 = var1.replace(" ", "");
      }

      return var1;
   }

   public String aD() {
      String var1 = this.l("table");
      if (var1 != null) {
         var1 = var1.replace(" ", "");
      }

      return var1;
   }

   public String aE() {
      String var1 = this.l("port");
      if (var1 != null) {
         var1 = var1.replace(" ", "");
         Double var2 = ai.idealistic.vacan.utils.b.a.an(var1);
         if (var2 != null) {
            var1 = String.valueOf(ai.idealistic.vacan.utils.b.a.z(var2));
         }

         return var1;
      } else {
         return null;
      }
   }

   public String aF() {
      String var1 = this.l("driver");
      if (var1 == null) {
         var1 = "mysql";
      }

      return var1;
   }

   public String aG() {
      return this.l("tls_Version");
   }

   public boolean aH() {
      return this.i("use_SSL");
   }

   public boolean aI() {
      return this.i("allow_public_key_retrieval");
   }

   public void clear() {
      super.clear();
      enabled = true;
   }

   public void aJ() {
      if (this.i(false)) {
         try {
            eJ.close();
         } catch (Exception var2) {
         }
      }

      eJ = null;
   }

   public boolean isEnabled() {
      return enabled;
   }

   public void ay() {
      this.b("host", "");
      this.b("user", "");
      this.b("password", "");
      this.b("database", "");
      this.b("table", "vacan_logs");
      this.b("port", "3306");
      this.b("driver", "mysql");
      this.b("tls_Version", "");
      this.b("use_SSL", true);
      this.b("allow_public_key_retrieval", false);
      this.b("escape_special_characters", false);
      eI.h(this::aK);
   }

   private boolean i(boolean var1) {
      if (eJ != null) {
         try {
            return !eJ.isClosed();
         } catch (Exception var3) {
            if (var1) {
               ai.idealistic.vacan.functionality.c.a.M("SQL Connection Check Error:\n" + var3.getMessage());
            }
         }
      }

      return false;
   }

   public void aK() {
      String var1 = this.az();
      String var2 = this.aA();
      String var3 = this.aB();
      String var4 = this.aC();
      String var5 = this.aD();
      String var6 = this.aE();
      int var7 = var1.length();
      int var8 = var2.length();
      int var9 = var3.length();
      int var10 = var4.length();
      if (var7 > 0 || var8 > 0 || var9 > 0 || var10 > 0) {
         if (var7 == 0) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Host is blank");
         } else if (var8 == 0) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: User is blank");
         } else if (var9 == 0) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Password is blank");
         } else if (var10 == 0) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Database is blank");
         } else if (var5.isEmpty()) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Table is blank");
         } else if (!ai.idealistic.vacan.utils.b.a.al(var6) && !ai.idealistic.vacan.utils.b.a.ao(var6)) {
            enabled = false;
            ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Port is not a valid number");
         } else if (!this.i(true)) {
            String var11 = this.aF();

            try {
               if (var11.isEmpty()) {
                  ai.idealistic.vacan.functionality.c.a.M("SQL Configuration Error: Driver is blank");
               } else {
                  String var12 = this.aG();
                  eJ = DriverManager.getConnection("jdbc:" + var11 + "://" + var1 + ":" + var6 + "/" + var4 + "?autoReconnect=true&maxReconnects=10" + (var12 != null && !var12.isEmpty() ? "&enabledTLSProtocols=TLSv" + var12 : "") + "&useSSL=" + this.aH() + "&allowPublicKeyRetrieval=" + this.aI(), var2, var3);
                  this.q(var5);
               }
            } catch (SQLException var13) {
               ai.idealistic.vacan.functionality.c.a.M("SQL Initial Connection Error:\n" + var13.getMessage());
               var13.printStackTrace();
            }
         }
      }

   }

   public void o(String var1) {
      eI.f(() -> {
         this.aK();

         try {
            if (eJ != null) {
               Statement var2 = eJ.createStatement();
               var2.executeUpdate(var1);
               var2.close();
            }
         } catch (Exception var3) {
            ai.idealistic.vacan.functionality.c.a.M("SQL Update Error:\nCommand: " + var1 + "\nException: " + var3.getMessage());
         }

      });
   }

   public ResultSet p(String var1) {
      ResultSet[] var2 = new ResultSet[1];
      Thread var3 = Thread.currentThread();
      eI.f(() -> {
         this.aK();

         try {
            if (eJ != null) {
               Statement var4 = eJ.createStatement();
               var2[0] = var4.executeQuery(var1);
               synchronized(var3) {
                  var3.notifyAll();
               }
            }
         } catch (Exception var8) {
            ai.idealistic.vacan.functionality.c.a.M("SQL Query Error:\nCommand: " + var1 + "\nException: " + var8.getMessage());
         }

      });
      synchronized(var3) {
         if (var2[0] == null) {
            try {
               var3.wait();
            } catch (Exception var7) {
            }
         }
      }

      return var2[0];
   }

   private void q(String var1) {
      this.o("CREATE TABLE IF NOT EXISTS " + var1 + " (id INT(11) NOT NULL AUTO_INCREMENT, creation_date VARCHAR(30), server_name VARCHAR(64), plugin_version VARCHAR(16), server_version VARCHAR(7), online_players INT(11), type VARCHAR(32), information VARCHAR(4096), notification VARCHAR(4096), player_uuid VARCHAR(36), player_name VARCHAR(24), player_latency INT(11), functionality VARCHAR(32), primary key (id));");
   }

   public void a(ai.idealistic.vacan.abstraction.f.c var1, String var2, String var3, Material var4, CheckEnums.HackType var5, long var6) {
      if (enabled) {
         String var8 = this.aD();
         boolean var9 = var1 != null;
         boolean var10 = var5 != null;
         boolean var11 = var4 != null;
         this.o("INSERT INTO " + var8 + " (creation_date, server_name, plugin_version, server_version, online_players, type, notification, information, player_uuid, player_name, player_latency, functionality) VALUES (" + this.d(ai.idealistic.vacan.functionality.d.a.a("yyyy/MM/dd HH:mm:ss:SSSXXX", var6)) + ", " + this.d(ai.idealistic.vacan.functionality.c.b.eP()) + ", " + this.d(VacanAPI.getVersion()) + ", " + this.d(MultiVersion.jf.toString()) + ", " + this.d(ai.idealistic.vacan.functionality.server.c.fa()) + ", " + this.d(var11 ? "mining" : (var10 ? "violation" : "other")) + ", " + (var2 != null ? this.d(var2) : "NULL") + ", " + this.d(var3) + ", " + (var9 ? this.d(var1.bT()) : "NULL") + ", " + (var9 ? this.d(var1.bC().getName()) : "NULL") + ", " + (var9 ? this.d(var1.bS()) : "NULL") + ", " + (var11 ? this.d(var4) : (var10 ? this.d(var5) : "NULL")) + ");");
      }

   }

   private String d(Object var1) {
      return "'" + var1.toString() + "'";
   }
}
