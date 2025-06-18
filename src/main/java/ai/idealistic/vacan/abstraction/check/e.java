package ai.idealistic.vacan.abstraction.check;

import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.GameMode;
import org.bukkit.event.Cancellable;

public abstract class e extends d {
   private static final boolean ad;
   final long ae = System.currentTimeMillis();
   private final Collection<a> af = Collections.synchronizedList(new ArrayList(1));
   private final Collection<a> ag = Collections.synchronizedList(new ArrayList(1));
   private boolean cancelled;
   private final Map<String, b> detections = new ConcurrentHashMap(2);

   public e(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   public final b e(String var1) {
      return (b)this.detections.get(var1);
   }

   public final Collection<b> getDetections() {
      return this.detections.values();
   }

   protected final b a(String var1, b var2) {
      return (b)this.detections.putIfAbsent(var1, var2);
   }

   public final void b(b var1) {
      this.detections.remove(var1.name);
   }

   public final void a(Object var1, Object var2) {
      boolean var3;
      if (var1 == null) {
         if (var2 instanceof Cancellable) {
            var3 = ((Cancellable)var2).isCancelled();
         } else {
            var3 = false;
         }
      } else if (var1 instanceof Boolean) {
         var3 = (Boolean)var1;
      } else if (var1 instanceof Cancellable) {
         var3 = ((Cancellable)var1).isCancelled();
      } else {
         var3 = false;
      }

      this.cancelled = var3;
      this.a(var3, var2);
   }

   protected void a(boolean var1, Object var2) {
   }

   protected boolean m() {
      return true;
   }

   final boolean i() {
      return !this.ac.gp && this.hackType.getCheck().a(this.ac.dr(), this.ac.bV().getName()) && (!this.cancelled || this.hackType.getCheck().g) && (!ad || this.ac.cl() != GameMode.SPECTATOR) && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "GENERIC_SCALE") == Double.MIN_VALUE;
   }

   final boolean n() {
      return (double)(System.currentTimeMillis() - this.ae) > 1000.0D && !ai.idealistic.vacan.compatibility.b.a.b.a(this.ac.bC()) && !ai.idealistic.vacan.functionality.server.b.isBypassing(this.ac.bC(), this.hackType);
   }

   public final List<String> o() {
      if (this.ac == null) {
         return new ArrayList();
      } else {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.getDetections().iterator();

         while(var2.hasNext()) {
            b var3 = (b)var2.next();
            if (var3.d(this.ac.dr()) >= var3.e(this.ac.dr())) {
               var1.add(var3.name);
            }
         }

         return var1;
      }
   }

   private a a(Collection<a> var1) {
      a var2 = null;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         a var4 = (a)var3.next();
         if (!var4.c()) {
            var2 = var4;
            break;
         }

         var3.remove();
      }

      return var2;
   }

   public final a p() {
      a var1 = this.a(this.af);
      if (var1 == null) {
         return ai.idealistic.vacan.compatibility.a.b.b.j(this.ac) ? new a(Compatibility.CompatibilityType.MYTHIC_MOBS) : (ai.idealistic.vacan.compatibility.a.a.d.j(this.ac) ? new a(Compatibility.CompatibilityType.ITEMS_ADDER) : (ai.idealistic.vacan.compatibility.a.d.a.m(this.ac) ? new a(Compatibility.CompatibilityType.CUSTOM_ENCHANTS_PLUS) : (ai.idealistic.vacan.compatibility.a.d.b.m(this.ac) ? new a(Compatibility.CompatibilityType.ECO_ENCHANTS) : null)));
      } else {
         return var1;
      }
   }

   public final a q() {
      return this.a(this.ag);
   }

   public final void a(String var1, String var2, int var3) {
      if (var1 == null) {
         var1 = this.hackType.getCheck().getName();
      }

      this.af.add(new a(var1, var2, var3));
      ai.idealistic.vacan.functionality.server.c.jm.z(this.ac.bC().getName());
   }

   public final void b(String var1, String var2, int var3) {
      this.ag.add(new a(var1, var2, var3));
      ai.idealistic.vacan.functionality.server.c.jm.z(this.ac.bC().getName());
   }

   public final void r() {
      this.af.clear();
      ai.idealistic.vacan.functionality.server.c.jm.z(this.ac.bC().getName());
   }

   public final void s() {
      this.ag.clear();
      ai.idealistic.vacan.functionality.server.c.jm.z(this.ac.bC().getName());
   }

   public final boolean j() {
      if (!this.detections.isEmpty()) {
         Iterator var1 = this.getDetections().iterator();

         while(var1.hasNext()) {
            b var2 = (b)var1.next();
            if (var2.j()) {
               return true;
            }
         }
      }

      return false;
   }

   final int a(ai.idealistic.vacan.abstraction.f.c var1) {
      Integer var2 = ai.idealistic.vacan.functionality.c.c.t(this.ac);
      if (var2 != null && var2 != Integer.MIN_VALUE) {
         return var2;
      } else {
         return var1 == null || !var1.equals(this.ac) && (!var1.bV().equals(this.ac.bV()) || !(var1.getLocation().distance(this.ac.getLocation()) <= 16.0D)) ? ai.idealistic.vacan.utils.b.a.A(20.0D) : ai.idealistic.vacan.utils.b.a.A(Math.sqrt(20.0D));
      }
   }

   static {
      ad = MultiVersion.c(MultiVersion.MCVersion.V1_8);
   }
}
