package ai.idealistic.vacan.functionality.connection;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.utils.a.f;
import ai.idealistic.vacan.utils.a.g;
import java.net.URLEncoder;
import java.util.UUID;

public class b {
   static int eJ() {
      try {
         String[] var0 = f.h(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?action=get&data=userIdentification&version=" + Register.plugin.getDescription().getVersion(), 30000);
         if (var0.length > 0) {
            String var1 = var0[0];
            if (ai.idealistic.vacan.utils.b.a.al(var1)) {
               int var2 = Integer.parseInt(var1);
               IDs.set(var2, var2);
               return var2;
            }
         }

         return -1;
      } catch (Exception var3) {
         a.a(var3, "userIdentification:GET");
         return 0;
      }
   }

   public static boolean eK() {
      if (IDs.canAdvertise()) {
         return true;
      } else {
         try {
            String[] var0 = f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=get&data=isSubscriptionBased&paypal_email=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.paypal_email"), "UTF-8") + "&patreon_full_name=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.patreon_full_name"), "UTF-8") + "&builtbybit_user_url=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.builtbybit_user_url"), "UTF-8") + "&version=" + Register.plugin.getDescription().getVersion());
            if (var0.length > 0) {
               return var0[0].equals("true");
            }
         } catch (Exception var1) {
            a.a(var1, "isSubscriptionBased:GET");
         }

         return false;
      }
   }

   public static boolean eL() {
      if (IDs.canAdvertise()) {
         return true;
      } else {
         try {
            String[] var0 = f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=get&data=ownsVacanOne&paypal_email=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.paypal_email"), "UTF-8") + "&patreon_full_name=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.patreon_full_name"), "UTF-8") + "&builtbybit_user_url=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.builtbybit_user_url"), "UTF-8") + "&version=" + Register.plugin.getDescription().getVersion());
            if (var0.length > 0) {
               return var0[0].equals("true");
            }
         } catch (Exception var1) {
            a.a(var1, "ownsVacanOne:GET");
         }

         return false;
      }
   }

   static String[] I(String var0) {
      try {
         String[] var1 = f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=get&data=ownsChecks&type=" + var0 + "&paypal_email=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.paypal_email"), "UTF-8") + "&patreon_full_name=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.patreon_full_name"), "UTF-8") + "&builtbybit_user_url=" + URLEncoder.encode(ai.idealistic.vacan.functionality.server.a.iZ.l("Purchases.builtbybit_user_url"), "UTF-8") + "&version=" + Register.plugin.getDescription().getVersion());
         if (var1.length > 0) {
            return var1[0].split(">@#&!%<;=", Check.DataType.values().length);
         }
      } catch (Exception var2) {
         a.a(var2, "ownsVacanOne:GET");
      }

      return null;
   }

   static String[][] eM() {
      try {
         String[] var0 = f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=get&data=staffAnnouncements&version=" + Register.plugin.getDescription().getVersion());
         if (var0.length > 0) {
            String[] var1 = var0[0].split(">@#&!%<;=");
            String[][] var2 = new String[var0.length][0];

            for(int var3 = 0; var3 < var1.length; ++var3) {
               var2[var3] = g.ac(var1[var3]).split(">@#&!%<;=");
            }

            return var2;
         }
      } catch (Exception var4) {
         a.a(var4, "staffAnnouncements:GET");
      }

      return new String[0][];
   }

   public static void a(String var0, UUID var1, String var2, int var3, int var4, int var5, String var6, String var7) {
      String var8 = ai.idealistic.vacan.functionality.server.a.iZ.l("Discord." + var0 + "_webhook_url");
      if (var8.startsWith("https://") || var8.startsWith("http://")) {
         String var9 = ai.idealistic.vacan.functionality.server.a.iZ.l("Discord.webhook_hex_color");
         int var10 = var9.length();
         if (var10 >= 3 && var10 <= 6) {
            ai.idealistic.vacan.functionality.server.c.jj.g(() -> {
               try {
                  byte var9x = 2;
                  String var10 = ai.idealistic.vacan.functionality.c.b.eP();
                  f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=add&data=discordWebhooks&version=" + Register.plugin.getDescription().getVersion() + "&value=" + URLEncoder.encode(var9x + ">@#&!%<;=" + var8 + ">@#&!%<;=" + var9 + ">@#&!%<;=" + (!var10.isEmpty() ? var10 : "NULL") + ">@#&!%<;=" + var2 + ">@#&!%<;=" + var1 + ">@#&!%<;=" + var3 + ">@#&!%<;=" + var4 + ">@#&!%<;=" + var5 + ">@#&!%<;=" + g.ag(var6) + ">@#&!%<;=" + g.ag(var7), "UTF-8"));
               } catch (Exception var11) {
                  a.a(var11, "discordWebhooks:ADD");
               }

            });
         }
      }

   }
}
