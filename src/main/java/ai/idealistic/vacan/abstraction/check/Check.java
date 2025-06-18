package ai.idealistic.vacan.abstraction.check;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.api.CheckPunishmentToggleEvent;
import ai.idealistic.vacan.api.CheckSilentToggleEvent;
import ai.idealistic.vacan.api.CheckToggleEvent;
import ai.idealistic.vacan.api.ToggleAction;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Check {
   private static boolean a = false;
   public static final int b = 10;
   private static final File d;
   private static final List<String> e;
   public final CheckEnums.HackType hackType;
   private String name;
   private final Map<String, Object> f = new ConcurrentHashMap();
   public final boolean g;
   private final boolean[] i;
   private final boolean[] j;
   private final boolean[] k;
   private final Set<String> n;
   private final Set<String> o;
   private final Collection<String> q;

   public static void a(boolean var0) {
      a = var0;
      ai.idealistic.vacan.functionality.server.a.ay();
   }

   public static boolean a() {
      return a;
   }

   public Check(CheckEnums.HackType var1) {
      this.hackType = var1;
      Object var2 = this.a("cancelled_event", false, false);
      String var3 = this.a("name", this.hackType.toString(), false).toString();
      String var4 = this.a("disabled_worlds", "exampleDisabledWorld1, exampleDisabledWorld2", false).toString();
      String var5 = this.a("silent_worlds", "exampleSilentWorld1, exampleSilentWorld2", false).toString();
      this.i = new boolean[Check.DataType.values().length];
      this.j = new boolean[Check.DataType.values().length];
      this.k = new boolean[Check.DataType.values().length];
      Check.DataType[] var6 = Check.DataType.values();
      int var7 = var6.length;

      int var8;
      for(var8 = 0; var8 < var7; ++var8) {
         Check.DataType var9 = var6[var8];
         Object var10 = this.a("enabled." + var9.toString().toLowerCase(), true, false);
         boolean var11 = var10 instanceof Boolean ? (Boolean)var10 : (!(var10 instanceof Long) && !(var10 instanceof Integer) && !(var10 instanceof Short) ? (!(var10 instanceof Double) && !(var10 instanceof Float) ? Boolean.parseBoolean(var10.toString().toLowerCase()) : (Double)var10 > 0.0D) : (Long)var10 > 0L);
         this.i[var9.ordinal()] = var11;
         var10 = this.a("silent." + var9.toString().toLowerCase(), false, false);
         this.j[var9.ordinal()] = var10 instanceof Boolean ? (Boolean)var10 : (!(var10 instanceof Long) && !(var10 instanceof Integer) && !(var10 instanceof Short) ? (!(var10 instanceof Double) && !(var10 instanceof Float) ? Boolean.parseBoolean(var10.toString().toLowerCase()) : (Double)var10 > 0.0D) : (Long)var10 > 0L);
         var10 = this.a("punishments.enabled." + var9.toString().toLowerCase(), true, false);
         this.k[var9.ordinal()] = var10 instanceof Boolean ? (Boolean)var10 : (!(var10 instanceof Long) && !(var10 instanceof Integer) && !(var10 instanceof Short) ? (!(var10 instanceof Double) && !(var10 instanceof Float) ? Boolean.parseBoolean(var10.toString().toLowerCase()) : (Double)var10 > 0.0D) : (Long)var10 > 0L);
      }

      if (var3 != null) {
         if (var3.length() > 32) {
            var3 = var3.substring(0, 32);
         }

         this.name = var3;
      } else {
         this.name = var1.toString();
      }

      if (var2 != null) {
         if (var2 instanceof Boolean) {
            this.g = (Boolean)var2;
         } else if (!(var2 instanceof Long) && !(var2 instanceof Integer) && !(var2 instanceof Short)) {
            if (!(var2 instanceof Double) && !(var2 instanceof Float)) {
               this.g = Boolean.parseBoolean(var2.toString().toLowerCase());
            } else {
               this.g = (Double)var2 > 0.0D;
            }
         } else {
            this.g = (Long)var2 > 0L;
         }
      } else {
         this.g = false;
      }

      String var12;
      String[] var15;
      HashSet var18;
      String[] var19;
      int var22;
      int var23;
      if (var4 != null) {
         var15 = var4.split(",");
         var7 = var15.length;
         if (var7 > 0) {
            var18 = new HashSet(var7);
            var19 = var15;
            var22 = var15.length;

            for(var23 = 0; var23 < var22; ++var23) {
               var12 = var19[var23];
               var12 = var12.replace(" ", "");
               if (!var12.isEmpty()) {
                  var18.add(var12.toLowerCase());
               }
            }

            if (!var18.isEmpty()) {
               this.n = var18;
            } else {
               this.n = new HashSet(0);
            }
         } else {
            this.n = new HashSet(0);
         }
      } else {
         this.n = new HashSet(0);
      }

      if (var5 != null) {
         var15 = var5.split(",");
         var7 = var15.length;
         if (var7 > 0) {
            var18 = new HashSet(var7);
            var19 = var15;
            var22 = var15.length;

            for(var23 = 0; var23 < var22; ++var23) {
               var12 = var19[var23];
               var12 = var12.replace(" ", "");
               if (!var12.isEmpty()) {
                  var18.add(var12.toLowerCase());
               }
            }

            if (!var18.isEmpty()) {
               this.o = var18;
            } else {
               this.o = new HashSet(0);
            }
         } else {
            this.o = new HashSet(0);
         }
      } else {
         this.o = new HashSet(0);
      }

      String var16 = var1 + ".punishments.commands";
      YamlConfiguration var17 = YamlConfiguration.loadConfiguration(d);
      if (!var17.contains(var16)) {
         for(var8 = 0; var8 < e.size(); ++var8) {
            ai.idealistic.vacan.utils.minecraft.c.a.a(d, var16 + "." + (var8 + 1), e.get(var8));
         }
      }

      ConfigurationSection var20 = var17.getConfigurationSection(var16);
      if (var20 != null) {
         ArrayList var21 = new ArrayList();
         Set var24 = var20.getKeys(true);
         if (!var24.isEmpty()) {
            var16 = var16 + ".";
            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               var12 = (String)var25.next();
               if (ai.idealistic.vacan.utils.b.a.al(var12)) {
                  int var13 = Integer.parseInt(var12);
                  if (var13 >= 1 && var13 <= 10) {
                     String var14 = var17.getString(var16 + var13);
                     if (var14 != null && !var14.isEmpty()) {
                        var21.add(var14);
                     }
                  }
               }
            }
         }

         this.q = var21;
      } else {
         this.q = new ArrayList(0);
      }

   }

   public boolean a(Check.DataType var1, String var2) {
      if (var1 == null) {
         boolean var3 = false;
         Check.DataType[] var4 = Check.DataType.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Check.DataType var7 = var4[var6];
            if (this.i[var7.ordinal()]) {
               var3 = true;
               break;
            }
         }

         if (!var3) {
            return false;
         }
      } else if (!this.i[var1.ordinal()]) {
         return false;
      }

      return var2 == null || !this.n.contains(var2.toLowerCase());
   }

   public void a(Check.DataType var1, boolean var2) {
      Check.DataType[] var3;
      Check.DataType[] var4;
      int var5;
      int var6;
      Check.DataType var7;
      if (var1 == null) {
         var3 = Check.DataType.values();
      } else {
         var3 = null;
         var4 = Check.DataType.values();
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            if (var7 == var1) {
               var3 = new Check.DataType[]{var1};
               break;
            }
         }

         if (var3 == null) {
            return;
         }
      }

      var4 = var3;
      var5 = var3.length;

      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         CheckToggleEvent var8;
         if (ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api")) {
            var8 = new CheckToggleEvent(this.hackType, var2 ? ToggleAction.ENABLE : ToggleAction.DISABLE);
            Bukkit.getPluginManager().callEvent(var8);
         } else {
            var8 = null;
         }

         if (var8 == null || !var8.isCancelled()) {
            this.i[var7.ordinal()] = var2;
            ai.idealistic.vacan.functionality.d.d.a(this.hackType, var7);
            this.a((String)("enabled." + var7.toString().toLowerCase()), (Object)var2);
            this.f.clear();
         }
      }

   }

   public void a(String var1) {
      if (var1.length() > 32) {
         var1 = var1.substring(0, 32);
      }

      CheckEnums.HackType[] var2 = CheckEnums.HackType.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         CheckEnums.HackType var5 = var2[var4];
         if (!var5.equals(this.hackType) && var1.equalsIgnoreCase(var5.toString()) || var1.equalsIgnoreCase(var5.getCheck().getName())) {
            return;
         }
      }

      this.name = var1;
      this.a((String)"name", (Object)var1);
   }

   private void a(String var1, Object var2) {
      try {
         String var3 = this.hackType + "." + var1;
         YamlConfiguration var4 = YamlConfiguration.loadConfiguration(d);
         var4.set(var3, var2);

         try {
            var4.save(d);
            this.f.remove(var3);
         } catch (Exception var6) {
            ai.idealistic.vacan.functionality.c.a.M("Failed to store '" + var3 + "' option in '" + d.getName() + "' file.");
            var6.printStackTrace();
         }

      } catch (Exception var7) {
         ai.idealistic.vacan.functionality.c.a.M("Failed to find/create the '" + d.getName() + "' file.");
         var7.printStackTrace();
         ai.idealistic.vacan.functionality.c.a.M("Failed to find/create the '" + d.getName() + "' file.");
      }
   }

   public Object a(String var1, Object var2, boolean var3) {
      if (var3) {
         Object var4 = this.f.get(var1);
         if (var4 != null) {
            return var4;
         }
      }

      try {
         String var11 = this.hackType + "." + var1;
         boolean var5 = var2 == null;
         YamlConfiguration var6 = YamlConfiguration.loadConfiguration(d);
         if (var3) {
            if (var6.contains(var11)) {
               Object var7 = var6.get(var11, var2);
               if (!var5) {
                  this.f.put(var1, var7);
               }

               return var7;
            }

            if (!var5) {
               var6.set(var11, var2);

               try {
                  var6.save(d);
                  this.f.put(var1, var2);
               } catch (Exception var9) {
                  ai.idealistic.vacan.functionality.c.a.M("Failed to store '" + var11 + "' option in '" + d.getName() + "' file.");
                  var9.printStackTrace();
               }
            }
         } else {
            if (var6.contains(var11)) {
               return var6.get(var11, var2);
            }

            if (!var5) {
               var6.set(var11, var2);

               try {
                  var6.save(d);
               } catch (Exception var8) {
                  ai.idealistic.vacan.functionality.c.a.M("Failed to store '" + var11 + "' option in '" + d.getName() + "' file.");
                  var8.printStackTrace();
               }
            }
         }
      } catch (Exception var10) {
         ai.idealistic.vacan.functionality.c.a.M("Failed to find/create the '" + d.getName() + "' file.");
         var10.printStackTrace();
      }

      return var2;
   }

   public boolean a(String var1, Boolean var2) {
      Object var3 = this.a(var1, var2, true);
      return var3 instanceof Boolean ? (Boolean)var3 : (var3 instanceof String ? Boolean.parseBoolean(var3.toString().toLowerCase()) : (!(var3 instanceof Long) && !(var3 instanceof Integer) && !(var3 instanceof Short) ? (!(var3 instanceof Double) && !(var3 instanceof Float) ? var2 != null && var2 : (Double)var3 > 0.0D) : (Long)var3 > 0L));
   }

   public int a(String var1, int var2) {
      Object var3 = this.a(var1, var2, true);
      if (!(var3 instanceof Integer) && !(var3 instanceof Short)) {
         if (!(var3 instanceof String) && !(var3 instanceof Long)) {
            if (!(var3 instanceof Double) && !(var3 instanceof Float)) {
               return var2;
            } else {
               try {
                  return ai.idealistic.vacan.utils.b.a.A(Double.parseDouble(var3.toString()));
               } catch (Exception var5) {
                  return var2;
               }
            }
         } else {
            try {
               return Integer.parseInt(var3.toString());
            } catch (Exception var6) {
               return var2;
            }
         }
      } else {
         return (Integer)var3;
      }
   }

   public double a(String var1, double var2) {
      Object var4 = this.a(var1, var2, true);
      if (!(var4 instanceof Double) && !(var4 instanceof Float)) {
         if (var4 instanceof Long) {
            return ((Long)var4).doubleValue();
         } else if (var4 instanceof Integer) {
            return ((Integer)var4).doubleValue();
         } else if (var4 instanceof Short) {
            return ((Short)var4).doubleValue();
         } else if (var4 instanceof String) {
            try {
               return Double.parseDouble(var4.toString());
            } catch (Exception var6) {
               return var2;
            }
         } else {
            return var2;
         }
      } else {
         return (Double)var4;
      }
   }

   public boolean a(Check.DataType var1) {
      if (a) {
         return false;
      } else if (var1 == null) {
         Check.DataType[] var2 = Check.DataType.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Check.DataType var5 = var2[var4];
            if (this.k[var5.ordinal()]) {
               return true;
            }
         }

         return false;
      } else {
         return this.k[var1.ordinal()];
      }
   }

   public boolean b(Check.DataType var1, String var2) {
      if (!a && (var2 == null || !this.o.contains(var2.toLowerCase()))) {
         if (var1 == null) {
            Check.DataType[] var3 = Check.DataType.values();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               Check.DataType var6 = var3[var5];
               if (this.j[var6.ordinal()]) {
                  return true;
               }
            }

            return false;
         } else {
            return this.j[var1.ordinal()];
         }
      } else {
         return true;
      }
   }

   public void b(Check.DataType var1, boolean var2) {
      Check.DataType[] var3;
      Check.DataType[] var4;
      int var5;
      int var6;
      Check.DataType var7;
      if (var1 == null) {
         var3 = Check.DataType.values();
      } else {
         var3 = null;
         var4 = Check.DataType.values();
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            if (var7 == var1) {
               var3 = new Check.DataType[]{var1};
               break;
            }
         }

         if (var3 == null) {
            return;
         }
      }

      var4 = var3;
      var5 = var3.length;

      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         CheckSilentToggleEvent var8;
         if (ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api")) {
            var8 = new CheckSilentToggleEvent(this.hackType, var2 ? ToggleAction.ENABLE : ToggleAction.DISABLE);
            Bukkit.getPluginManager().callEvent(var8);
         } else {
            var8 = null;
         }

         if (var8 == null || !var8.isCancelled()) {
            this.j[var7.ordinal()] = var2;
            this.a((String)("silent." + var7.toString().toLowerCase()), (Object)var2);
            this.f.clear();
         }
      }

   }

   public List<String> b() {
      return new ArrayList(this.q);
   }

   public void c(Check.DataType var1, boolean var2) {
      Check.DataType[] var3;
      if (var1 == null) {
         var3 = Check.DataType.values();
      } else {
         var3 = new Check.DataType[]{var1};
      }

      Check.DataType[] var4 = var3;
      int var5 = var3.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Check.DataType var7 = var4[var6];
         CheckPunishmentToggleEvent var8;
         if (ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api")) {
            var8 = new CheckPunishmentToggleEvent(this.hackType, var2 ? ToggleAction.ENABLE : ToggleAction.DISABLE);
            Bukkit.getPluginManager().callEvent(var8);
         } else {
            var8 = null;
         }

         if (var8 == null || !var8.isCancelled()) {
            this.k[var7.ordinal()] = var2;
            this.a((String)("punishments.enabled." + var7.toString().toLowerCase()), (Object)var2);
            this.f.clear();
         }
      }

   }

   @Generated
   public String getName() {
      return this.name;
   }

   static {
      d = new File(Register.plugin.getDataFolder() + "/checks.yml");
      e = new ArrayList(10);
      e.add("vacan kick {player} {detections}");

      for(int var0 = e.size() + 1; var0 <= 10; ++var0) {
         e.add("");
      }

   }

   public static enum DataType {
      JAVA,
      BEDROCK;

      private final String string;

      private DataType() {
         switch(this.ordinal()) {
         case 0:
            this.string = "Java";
            break;
         case 1:
            this.string = "Bedrock";
            break;
         default:
            this.string = "Universal";
         }

      }

      public String toString() {
         return this.string;
      }

      // $FF: synthetic method
      private static Check.DataType[] $values() {
         return new Check.DataType[]{JAVA, BEDROCK};
      }
   }

   public static enum DetectionType {
      BUKKIT,
      PACKETS;

      private final String string;

      private DetectionType() {
         if (this.ordinal() == 0) {
            this.string = "Bukkit";
         } else {
            this.string = "Packets";
         }

      }

      public String toString() {
         return this.string;
      }

      // $FF: synthetic method
      private static Check.DetectionType[] $values() {
         return new Check.DetectionType[]{BUKKIT, PACKETS};
      }
   }
}
