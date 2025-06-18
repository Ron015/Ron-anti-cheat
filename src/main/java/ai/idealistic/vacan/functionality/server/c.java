package ai.idealistic.vacan.functionality.server;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.compatibility.Compatibility;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class c {
   public static final ai.idealistic.vacan.functionality.b.b.a jj = new ai.idealistic.vacan.functionality.b.b.a(50L);
   public static final ai.idealistic.vacan.functionality.b.b.a jk = new ai.idealistic.vacan.functionality.b.b.a(1L);
   public static final ai.idealistic.vacan.abstraction.e.a.a jl = new ai.idealistic.vacan.abstraction.e.a.a();
   public static final ai.idealistic.vacan.abstraction.e.a.b jm = new ai.idealistic.vacan.abstraction.e.a.b();
   public static final ai.idealistic.vacan.abstraction.e.a[] jn;
   public static final int jo = 31;
   public static final int jp;
   public static final int jq;
   private static final Map<UUID, ai.idealistic.vacan.abstraction.f.c> jr;
   public static final Class<?> js;

   public static int fa() {
      return jr.size();
   }

   public static boolean fb() {
      return !jr.isEmpty();
   }

   public static Collection<ai.idealistic.vacan.abstraction.f.c> fc() {
      return jr.values();
   }

   public static Set<Entry<UUID, ai.idealistic.vacan.abstraction.f.c>> fd() {
      return jr.entrySet();
   }

   public static boolean fe() {
      return Bukkit.isPrimaryThread() || !Register.isPluginEnabled();
   }

   public static Object b(Player var0, String var1) {
      if (js != null) {
         try {
            Object var2 = js.getMethod("getHandle").invoke(var0);
            return var2.getClass().getDeclaredField(var1).get(var2);
         } catch (Exception var3) {
         }
      }

      return -1;
   }

   public static boolean bW() {
      return Compatibility.CompatibilityType.PROTOCOL_LIB.isFunctional();
   }

   public static ai.idealistic.vacan.abstraction.f.c a(Player var0, boolean var1) {
      if (ai.idealistic.vacan.compatibility.b.a.b.a(var0)) {
         return new ai.idealistic.vacan.abstraction.f.c(var0);
      } else {
         ai.idealistic.vacan.abstraction.f.c var2 = (ai.idealistic.vacan.abstraction.f.c)jr.get(var0.getUniqueId());
         if (var2 == null) {
            var2 = new ai.idealistic.vacan.abstraction.f.c(var0);
            jr.put(var0.getUniqueId(), var2);
         } else {
            var2.a(var0);
         }

         if (var1) {
            var2.bZ();
         }

         return var2;
      }
   }

   public static ai.idealistic.vacan.abstraction.f.c i(Player var0) {
      return a(var0, false);
   }

   public static ai.idealistic.vacan.abstraction.f.c P(String var0) {
      if (!jr.isEmpty()) {
         Iterator var1 = jr.values().iterator();

         while(var1.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var2 = (ai.idealistic.vacan.abstraction.f.c)var1.next();
            if (var2.bC().getName().equals(var0)) {
               return var2;
            }
         }
      }

      return null;
   }

   public static ai.idealistic.vacan.abstraction.f.c Q(String var0) {
      if (!jr.isEmpty()) {
         Iterator var1 = jr.values().iterator();

         while(var1.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var2 = (ai.idealistic.vacan.abstraction.f.c)var1.next();
            if (var2.bC().getName().equalsIgnoreCase(var0)) {
               return var2;
            }
         }
      }

      return null;
   }

   public static ai.idealistic.vacan.abstraction.f.c l(int var0) {
      Iterator var1 = jr.values().iterator();

      ai.idealistic.vacan.abstraction.f.c var2;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         var2 = (ai.idealistic.vacan.abstraction.f.c)var1.next();
      } while(var2.ci() != var0);

      return var2;
   }

   public static ai.idealistic.vacan.abstraction.f.c c(UUID var0) {
      if (fe()) {
         Player var1 = Bukkit.getPlayer(var0);
         return var1 != null ? i(var1) : (ai.idealistic.vacan.abstraction.f.c)jr.get(var0);
      } else {
         return (ai.idealistic.vacan.abstraction.f.c)jr.get(var0);
      }
   }

   public static ai.idealistic.vacan.abstraction.f.c j(Player var0) {
      if (ai.idealistic.vacan.compatibility.b.a.b.a(var0)) {
         return null;
      } else {
         ai.idealistic.vacan.abstraction.f.c var1 = (ai.idealistic.vacan.abstraction.f.c)jr.remove(var0.getUniqueId());
         if (var1 != null && !var1.cb()) {
            var1.bU().bw().a(System.currentTimeMillis(), var1.bE(), true);
         }

         return var1;
      }
   }

   public static Object a(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1, long var2) {
      return d.b(var0, var1, var2, -1L);
   }

   public static Object a(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1, long var2, long var4) {
      return d.b(var0, var1, var2, var4);
   }

   public static Object a(Runnable var0, long var1) {
      return d.b((ai.idealistic.vacan.abstraction.f.c)null, var0, var1, -1L);
   }

   public static Object a(Runnable var0, long var1, long var3) {
      return d.b((ai.idealistic.vacan.abstraction.f.c)null, var0, var1, var3);
   }

   public static void a(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1) {
      d.a(var0, var1, false);
   }

   public static void a(World var0, int var1, int var2, Runnable var3) {
      d.a(var0, var1, var2, var3, false);
   }

   public static void b(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1) {
      d.a(var0, var1, true);
   }

   public static void b(World var0, int var1, int var2, Runnable var3) {
      d.a(var0, var1, var2, var3, true);
   }

   public static void i(Runnable var0) {
      d.j(var0);
   }

   public static void h(Object var0) {
      d.i(var0);
   }

   public static void R(String var0) {
      Bukkit.getScheduler().runTask(Register.plugin, () -> {
         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), var0);
      });
   }

   public static void eB() {
      if (!jr.isEmpty()) {
         Iterator var0 = jr.values().iterator();

         while(var0.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var1 = (ai.idealistic.vacan.abstraction.f.c)var0.next();
            if (var1 != null && !var1.cb()) {
               var1.bU().bw().a(System.currentTimeMillis(), var1.bE(), true);
            }
         }
      }

      jr.clear();
      ai.idealistic.vacan.functionality.b.b.eB();
      ai.idealistic.vacan.listeners.a.clear();
      a.ay();
   }

   static {
      jn = new ai.idealistic.vacan.abstraction.e.a[]{jl, jm};
      jp = ai.idealistic.vacan.utils.b.a.A((double)Runtime.getRuntime().maxMemory() * 0.05D);
      jq = jp / 1024;
      jr = new ConcurrentHashMap();
      js = MultiVersion.c(MultiVersion.MCVersion.V1_17) ? null : ai.idealistic.vacan.utils.a.e.Z(ai.idealistic.vacan.utils.a.e.class.getPackage().getName().substring(0, 19) + "org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().substring(23) + ".entity.CraftPlayer");
   }
}
