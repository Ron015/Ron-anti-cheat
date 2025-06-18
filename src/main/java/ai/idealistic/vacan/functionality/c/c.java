package ai.idealistic.vacan.functionality.c;

import ai.idealistic.vacan.api.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class c {
   public static final int iU = Integer.MIN_VALUE;
   private static final Map<UUID, Integer> iV = new ConcurrentHashMap();
   private static final Map<UUID, Boolean> iW = new ConcurrentHashMap();

   public static List<ai.idealistic.vacan.abstraction.f.c> eR() {
      if (!iV.isEmpty()) {
         ArrayList var0 = new ArrayList(iV.size());
         Iterator var1 = iV.keySet().iterator();

         while(var1.hasNext()) {
            UUID var2 = (UUID)var1.next();
            ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.c(var2);
            if (var3 != null) {
               var0.add(var3);
            }
         }

         return var0;
      } else {
         return new ArrayList(0);
      }
   }

   public static boolean q(ai.idealistic.vacan.abstraction.f.c var0) {
      return iV.containsKey(var0.bT());
   }

   public static boolean r(ai.idealistic.vacan.abstraction.f.c var0) {
      return iW.containsKey(var0.bT());
   }

   public static boolean s(ai.idealistic.vacan.abstraction.f.c var0) {
      return ai.idealistic.vacan.functionality.server.b.a(var0.bC(), Permission.NOTIFICATIONS);
   }

   public static Integer t(ai.idealistic.vacan.abstraction.f.c var0) {
      return (Integer)iV.get(var0.bT());
   }

   public static void u(ai.idealistic.vacan.abstraction.f.c var0) {
      iV.remove(var0.bT());
   }

   public static void v(ai.idealistic.vacan.abstraction.f.c var0) {
      UUID var1 = var0.bT();
      if (iW.containsKey(var1)) {
         iW.remove(var1);
         var0.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("verbose_disable"));
      }

   }

   public static void c(ai.idealistic.vacan.abstraction.f.c var0, int var1) {
      Integer var2 = (Integer)iV.put(var0.bT(), var1);
      if (var2 == null) {
         var0.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("notifications_enable"));
      } else if (var2 != var1) {
         var0.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("notifications_modified"));
      } else {
         iV.remove(var0.bT());
         var0.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("notifications_disable"));
      }

   }

   public static void w(ai.idealistic.vacan.abstraction.f.c var0) {
      UUID var1 = var0.bT();
      if (!iW.containsKey(var1)) {
         iW.put(var1, true);
         var0.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("verbose_enable"));
      }

   }

   public static void x(ai.idealistic.vacan.abstraction.f.c var0) {
      if (iV.containsKey(var0.bT()) && !s(var0)) {
         iV.remove(var0.bT());
      }

   }
}
