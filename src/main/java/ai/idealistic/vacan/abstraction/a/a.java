package ai.idealistic.vacan.abstraction.a;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.functionality.connection.e;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class a {
   protected static final String eC = "{prefix}";
   protected final File d;
   private final Map<String, Boolean> eD = new ConcurrentHashMap();
   private final Map<String, Boolean> eE = new ConcurrentHashMap();
   private final Map<String, Integer> eF = new ConcurrentHashMap();
   private final Map<String, Double> eG = new ConcurrentHashMap();
   private final Map<String, String> eH = new ConcurrentHashMap();

   public static String g(String var0) {
      return Register.plugin.getDataFolder() + "/" + var0 + ".yml";
   }

   public a(String var1) {
      this.d = new File(g(var1));
   }

   protected final YamlConfiguration av() {
      if (!this.d.exists()) {
         this.ay();
      }

      return YamlConfiguration.loadConfiguration(this.d);
   }

   protected final void aw() {
      this.eD.clear();
      this.eE.clear();
      this.eF.clear();
      this.eH.clear();
   }

   public final File ax() {
      return this.d;
   }

   public final boolean h(String var1) {
      Boolean var2 = (Boolean)this.eE.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         boolean var3 = this.av().contains(var1);
         this.eE.put(var1, var3);
         return var3;
      }
   }

   public final boolean i(String var1) {
      Boolean var2 = (Boolean)this.eD.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         boolean var3 = this.av().getBoolean(var1);
         this.eD.put(var1, var3);
         return var3;
      }
   }

   public final int j(String var1) {
      Integer var2 = (Integer)this.eF.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         int var3 = this.av().getInt(var1);
         this.eF.put(var1, var3);
         return var3;
      }
   }

   public final double k(String var1) {
      Double var2 = (Double)this.eG.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         double var3 = this.av().getDouble(var1);
         this.eG.put(var1, var3);
         return var3;
      }
   }

   public final String l(String var1) {
      String var2 = (String)this.eH.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         String var3 = this.av().getString(var1);
         if (var3 == null) {
            return var1;
         } else {
            this.eH.put(var1, var3);
            return var3;
         }
      }
   }

   public final String m(String var1) {
      String var2 = (String)this.eH.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         if (!this.d.exists()) {
            this.ay();
         }

         String var3 = this.av().getString(var1);
         if (var3 == null) {
            return var1;
         } else {
            var3 = ChatColor.translateAlternateColorCodes('&', var3);
            var3 = var3.replace("{prefix}", e.J(var3));
            this.eH.put(var1, var3);
            return var3;
         }
      }
   }

   public final void n(String var1) {
      this.eD.remove(var1);
      this.eE.remove(var1);
      this.eF.remove(var1);
      this.eG.remove(var1);
      this.eH.remove(var1);
   }

   public final void a(String var1, Object var2) {
      ai.idealistic.vacan.utils.minecraft.c.a.b(this.d, var1, var2);
      this.n(var1);
   }

   protected final void b(String var1, Object var2) {
      ai.idealistic.vacan.utils.minecraft.c.a.a(this.d, var1, var2);
      this.n(var1);
   }

   public final String a(String var1, String var2) {
      return this.h(var1) ? var1 : var2;
   }

   public void clear() {
      this.aw();
   }

   public abstract void ay();
}
