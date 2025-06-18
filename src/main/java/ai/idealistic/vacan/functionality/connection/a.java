package ai.idealistic.vacan.functionality.connection;

import java.util.Iterator;
import java.util.List;

public class a {
   private static long iu = 0L;
   private static long iv = 0L;
   private static final long iw = 60000L;
   static final String ix = ">@#&!%<;=";

   public static void n(ai.idealistic.vacan.abstraction.f.c var0) {
      if (ai.idealistic.vacan.functionality.server.b.h(var0.bC())) {
         ai.idealistic.vacan.functionality.server.c.jj.f(() -> {
            String[][] var1 = b.eM();
            if (var1.length > 0) {
               String[][] var2 = var1;
               int var3 = var1.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  String[] var5 = var2[var4];
                  if (ai.idealistic.vacan.functionality.c.a.a(var0.bT(), "staff-announcement-" + var5[0], Integer.parseInt(var5[2]))) {
                     var0.bC().sendMessage(ai.idealistic.vacan.functionality.c.a.K(var5[1]));
                  }
               }
            }

         });
      }

   }

   public static void a(Exception var0, String var1) {
      long var2 = System.currentTimeMillis();
      if (iv >= var2) {
         iv = var2 + 60000L;
         String var4 = "(" + var1 + ") Failed to connect to the Game Cloud.\nError: " + var0.getMessage() + "\nIn Depth: " + var0;
         ai.idealistic.vacan.functionality.c.a.N(var4);
      }

   }

   public static String eH() {
      return "identification=" + IDs.platform() + "|" + IDs.user() + "|" + IDs.file();
   }

   public static void eI() {
      long var0 = System.currentTimeMillis();
      if (iu <= var0) {
         iu = var0 + 60000L;
         ai.idealistic.vacan.functionality.server.c.jj.g(e::eI);
         ai.idealistic.vacan.functionality.server.c.jj.g(() -> {
            List var0 = ai.idealistic.vacan.functionality.server.b.eZ();
            if (!var0.isEmpty()) {
               String[][] var1 = b.eM();
               if (var1.length > 0) {
                  String[][] var2 = var1;
                  int var3 = var1.length;

                  for(int var4 = 0; var4 < var3; ++var4) {
                     String[] var5 = var2[var4];
                     Iterator var6 = var0.iterator();

                     while(var6.hasNext()) {
                        ai.idealistic.vacan.abstraction.f.c var7 = (ai.idealistic.vacan.abstraction.f.c)var6.next();
                        if (ai.idealistic.vacan.functionality.c.a.a(var7.bT(), "staff-announcement-" + var5[0], Integer.parseInt(var5[2]))) {
                           var7.bC().sendMessage(ai.idealistic.vacan.functionality.c.a.K(var5[1]));
                        }
                     }
                  }
               } else {
                  Iterator var8 = var0.iterator();

                  while(var8.hasNext()) {
                     ai.idealistic.vacan.abstraction.f.c var9 = (ai.idealistic.vacan.abstraction.f.c)var8.next();
                     e.p(var9);
                  }
               }
            }

         });
      }

   }

   static {
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         ai.idealistic.vacan.functionality.server.c.jj.f(a::eI);
      }, 1L, 60000L);
   }
}
