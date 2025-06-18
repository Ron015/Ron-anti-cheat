package ai.idealistic.vacan.functionality.connection;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.bukkit.Bukkit;

public class e {
   private static final String[] iB = new String[]{"25638", "11196", "350"};
   private static final Check.DataType iC;
   private static final Check.DataType iD;
   private static long iE = 0L;
   public static final String iF = "https://www.patreon.com/VacanAntiCheat";
   private static final int iG = 3600;
   private static final String iH = "{type}";
   private static final String iI = "{product}";
   private static final String iJ = "\n§cHey, just a heads up! You have {type} players which cannot be checked by the anti-cheat due to missing {type} detections.";
   private static boolean iK = false;
   private static boolean iL = false;
   private static boolean iM = false;
   private static final CheckEnums.HackCategoryType[] iN;
   private static final boolean[][] iO;

   public static void eI() {
      ai.idealistic.vacan.functionality.server.c.jj.g(() -> {
         boolean var0 = b.eK();
         if (!iL) {
            iL = var0 || b.eL();
         }

         CheckEnums.HackCategoryType[] var1 = iN;
         int var2 = var1.length;

         int var3;
         int var8;
         for(var3 = 0; var3 < var2; ++var3) {
            CheckEnums.HackCategoryType var4 = var1[var3];
            if (!iO[iC.ordinal()][var4.ordinal()] || !iO[iD.ordinal()][var4.ordinal()]) {
               if (!var0 && ai.idealistic.vacan.functionality.server.a.iZ.h("Purchases.opt_out_from_subscriptions") && ai.idealistic.vacan.functionality.server.a.iZ.i("Purchases.opt_out_from_subscriptions")) {
                  iO[iC.ordinal()][var4.ordinal()] = true;
                  iO[iD.ordinal()][var4.ordinal()] = true;
               } else {
                  String[] var5 = b.I(var4.toString());
                  if (var5 != null) {
                     String[] var6 = var5;
                     int var7 = var5.length;

                     for(var8 = 0; var8 < var7; ++var8) {
                        String var9 = var6[var8];
                        Check.DataType[] var10 = Check.DataType.values();
                        int var11 = var10.length;

                        for(int var12 = 0; var12 < var11; ++var12) {
                           Check.DataType var13 = var10[var12];
                           if (var9.equals(var13.toString())) {
                              iO[var13.ordinal()][var4.ordinal()] = true;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (!iM && iL) {
            String var14 = Register.plugin.getDataFolder().toString().replace("Vacan", "");
            File[] var15 = (new File(var14)).listFiles();
            var3 = var15.length;

            for(int var16 = 0; var16 < var3; ++var16) {
               File var17 = var15[var16];
               if (var17.isFile() && var17.getName().endsWith(".jar")) {
                  Object var18 = ai.idealistic.vacan.utils.a.e.a(var17.getAbsolutePath(), IDs.class.getCanonicalName(), "user");
                  if (var18 != null && var18.toString().equals("1897975")) {
                     var18 = ai.idealistic.vacan.utils.a.e.a(var17.getAbsolutePath(), IDs.class.getCanonicalName(), "resource");
                     if (var18 != null && !var18.toString().equals("25638")) {
                        int var22;
                        if (iC == Check.DataType.JAVA) {
                           boolean var20 = false;
                           String[] var21 = iB;
                           var22 = var21.length;

                           for(int var24 = 0; var24 < var22; ++var24) {
                              String var25 = var21[var24];
                              if (var25.equals(var18.toString())) {
                                 var20 = true;
                                 break;
                              }
                           }

                           if (!var20) {
                              iM = true;
                              break;
                           }
                        } else {
                           String[] var19 = iB;
                           var8 = var19.length;

                           for(var22 = 0; var22 < var8; ++var22) {
                              String var23 = var19[var22];
                              if (var23.equals(var18.toString())) {
                                 iM = true;
                                 break;
                              }
                           }

                           if (iM) {
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

      });
   }

   public static boolean j(Check.DataType var0) {
      return iC == var0 || iM;
   }

   public static boolean a(Check.DataType var0, CheckEnums.HackCategoryType var1) {
      return j(var0) && (var1.ordinal() >= iN.length || iO[var0.ordinal()][var1.ordinal()]);
   }

   public static String eN() {
      return iC == Check.DataType.JAVA ? "1" : "16";
   }

   public static String J(String var0) {
      String var1 = null;
      boolean var2 = false;
      char[] var3 = var0.toCharArray();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char var6 = var3[var5];
         if (var6 == 167) {
            var2 = true;
         } else if (var2) {
            var1 = Character.toString(var6);
            var2 = false;
         }
      }

      return "Vacan: §a" + iC + "§8/" + (iM ? "§a" : "§c") + iD + (var1 != null ? "§" + var1 : "");
   }

   public static void p(ai.idealistic.vacan.abstraction.f.c var0) {
      Check.DataType[] var1 = !iM ? new Check.DataType[]{iD} : new Check.DataType[0];
      if (var1.length > 0) {
         if (iK) {
            a(var0, var1[0]);
            return;
         }

         long var2 = System.currentTimeMillis();
         if (var2 - iE >= 60000L) {
            iE = var2;
            if (var1[0] == var0.dr()) {
               iK = true;
               a(var0, var1[0]);
               return;
            }

            Collection var4 = ai.idealistic.vacan.functionality.server.c.fc();
            var4.remove(var0);
            int var5 = var4.size();
            ArrayList var6;
            if (var5 > 0) {
               var6 = new ArrayList(var5);
               Iterator var7 = var4.iterator();

               while(var7.hasNext()) {
                  ai.idealistic.vacan.abstraction.f.c var8 = (ai.idealistic.vacan.abstraction.f.c)var7.next();
                  if (var1[0] == var8.dr()) {
                     iK = true;
                     a(var8, var1[0]);
                     return;
                  }

                  var6.add(var8.bU());
               }
            } else {
               var6 = new ArrayList(0);
            }

            Collection var10 = ai.idealistic.vacan.functionality.d.d.fi();
            if (!var10.isEmpty()) {
               var10.remove(var0.bU());
               var10.removeAll(var6);
               if (!var10.isEmpty()) {
                  Iterator var11 = var10.iterator();

                  while(var11.hasNext()) {
                     ai.idealistic.vacan.abstraction.profiling.a var9 = (ai.idealistic.vacan.abstraction.profiling.a)var11.next();
                     if (var9.bv() == var1[0]) {
                        iK = true;
                        a(var0, var1[0]);
                        return;
                     }
                  }
               }
            }
         }
      }

   }

   private static void a(ai.idealistic.vacan.abstraction.f.c var0, Check.DataType var1) {
      String var2 = ai.idealistic.vacan.functionality.c.a.L(("\n§cHey, just a heads up! You have {type} players which cannot be checked by the anti-cheat due to missing {type} detections." + (IDs.canAdvertise() ? " Click §n{product}§r§c to §lfix this§r§c." : " Visit §nhttps://www.idealistic.ai/discord/vacan§r§c to §lfix this§r§c.")).replace("{type}", var1.toString()).replace("{product}", IDs.builtByBit ? (var1 == Check.DataType.JAVA ? "https://builtbybit.com/resources/12832" : "https://builtbybit.com/resources/11196") : (var1 == Check.DataType.JAVA ? "https://polymart.org/resource/3600" : "https://polymart.org/resource/350")));
      if (var2 != null && ai.idealistic.vacan.functionality.c.a.a(var0.bT(), "alternative-version", 3600)) {
         var0.C(var2);
      }

   }

   static {
      iN = new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.COMBAT, CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.WORLD};
      iO = new boolean[Check.DataType.values().length][iN.length];
      Check.DataType var0 = Check.DataType.BEDROCK;
      if (!IDs.enabled && Bukkit.getMotd().contains("Vacan")) {
         var0 = Check.DataType.JAVA;
      } else {
         String[] var1 = iB;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            String var4 = var1[var3];
            if (var4.equals("25638")) {
               var0 = Check.DataType.JAVA;
               break;
            }
         }
      }

      iC = var0;
      iD = iC == Check.DataType.JAVA ? Check.DataType.BEDROCK : Check.DataType.JAVA;
   }
}
