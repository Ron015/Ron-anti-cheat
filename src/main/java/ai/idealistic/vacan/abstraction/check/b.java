package ai.idealistic.vacan.abstraction.check;

import ai.idealistic.vacan.api.CheckCancelEvent;
import ai.idealistic.vacan.api.PlayerViolationCommandEvent;
import ai.idealistic.vacan.api.PlayerViolationEvent;
import ai.idealistic.vacan.api.VacanAPI;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public abstract class b extends d {
   private static long u = 0L;
   private static Method v = null;
   public static final String w = "Java:";
   public static final String x = "Check:";
   public static final String y = "Detection:";
   public static final String z = "Level:";
   public static final String A = "Notification-Level:";
   public static final String B = "Prevention-Level:";
   public static final String C = "Punishment-Level:";
   public static final long D = 500L;
   public static final long E = 60000L;
   public static final long F = 40000L;
   public static final long G = 30000L;
   c H;
   public final e I;
   public final String name;
   public final boolean J;
   private final Boolean K;
   public final Check.DataType L;
   public final Check.DetectionType M;
   public final long N;
   public final long O;
   public final long P;
   public final long Q;
   private final long[] R;
   private final long[] S;
   private long T;
   private long U;

   protected static void f() {
      u = System.currentTimeMillis();
   }

   protected static long g() {
      return System.currentTimeMillis() - u;
   }

   public static int a(CheckEnums.HackType var0, String var1) {
      return var0.hashCode() * 31 + (var1 == null ? 0 : var1.hashCode());
   }

   public b(e var1, Check.DataType var2, Check.DetectionType var3, String var4, Boolean var5, long var6, long var8, long var10, long var12) {
      super(var1.hackType, var1.ac);
      this.I = var1;
      this.name = var4 == null ? Integer.toString(this.getClass().getName().hashCode()) : var4;
      this.J = var4 != null;
      this.K = var5;
      this.L = var2;
      this.M = var3;
      this.H = new c();
      this.T = 0L;
      this.N = var6;
      this.O = var8;
      this.P = var10;
      this.Q = var12;
      this.R = new long[Check.DataType.values().length];
      this.S = new long[Check.DataType.values().length];
      Check.DataType[] var14 = Check.DataType.values();
      int var15 = var14.length;

      for(int var16 = 0; var16 < var15; ++var16) {
         Check.DataType var17 = var14[var16];
         this.R[var17.ordinal()] = 0L;
         this.S[var17.ordinal()] = -1L;
      }

      this.isEnabled();
      if (var1.a(this.name, this) != null) {
         throw new IllegalArgumentException("Detection '" + this.name + "' already exists for enum '" + var1.hackType.toString() + "'.");
      } else {
         this.hackType.addDetection(this.name, var6);
      }
   }

   public b(e var1, Check.DataType var2, Check.DetectionType var3, String var4, Boolean var5) {
      this(var1, var2, var3, var4, var5, 500L, 30000L, 40000L, 60000L);
   }

   public final int h() {
      return a(this.hackType, this.name);
   }

   public final boolean isEnabled() {
      return !this.J || this.K == null || this.hackType.getCheck().a("check_" + this.name, this.K);
   }

   public final boolean i() {
      return this.I.i() && this.isEnabled() && (this.L == null || this.L == this.ac.dr()) && (this.M == null || this.M == this.ac.M);
   }

   public final void a(Runnable var1) {
      if (this.i()) {
         var1.run();
      }

   }

   public final void b(Check.DataType var1) {
      this.ac.bU().b(this.hackType, var1, this.name);
      this.R[this.ac.dr().ordinal()] = 0L;
      this.S[this.ac.dr().ordinal()] = -1L;
   }

   private void a(double var1, long var3) {
      double var5 = ai.idealistic.vacan.functionality.d.d.a(this, this.ac.dr());
      double var7 = v != null ? 20.0D - Bukkit.getTPS()[0] : 0.0D;
      double var9 = (20.0D - var7 * 2.0D) / 20.0D;
      long var11 = this.S[this.ac.dr().ordinal()];
      long var13;
      if (var11 == -1L) {
         var13 = (long)ai.idealistic.vacan.utils.b.a.A(var5 * var9 * var1);
      } else {
         long var15 = var3 - var11;
         this.ac.bU().a(this.hackType, this.ac.dr(), this.name, var3);
         double var17 = Math.min(var5 / (double)var15, 1.0D);
         var13 = (long)ai.idealistic.vacan.utils.b.a.A(var5 * var9 * var1 * var17);
      }

      this.S[this.ac.dr().ordinal()] = var3;
      if (this.R[this.ac.dr().ordinal()] <= System.currentTimeMillis()) {
         this.R[this.ac.dr().ordinal()] = System.currentTimeMillis() + var13;
      } else {
         long[] var10000 = this.R;
         int var10001 = this.ac.dr().ordinal();
         var10000[var10001] += var13;
      }

   }

   private long c(Check.DataType var1) {
      return Math.max(this.R[var1.ordinal()] - System.currentTimeMillis(), 0L);
   }

   public final int d(Check.DataType var1) {
      return ai.idealistic.vacan.utils.b.a.z((double)this.c(var1) / ai.idealistic.vacan.functionality.d.d.a(this, var1));
   }

   public final int e(Check.DataType var1) {
      return ai.idealistic.vacan.utils.b.a.B((double)this.O / ai.idealistic.vacan.functionality.d.d.a(this, var1));
   }

   public final int f(Check.DataType var1) {
      return ai.idealistic.vacan.utils.b.a.B((double)this.P / ai.idealistic.vacan.functionality.d.d.a(this, var1));
   }

   public final int g(Check.DataType var1) {
      return ai.idealistic.vacan.utils.b.a.B((double)this.Q / ai.idealistic.vacan.functionality.d.d.a(this, var1));
   }

   public final boolean a(long var1, int var3, int var4) {
      int var5 = this.I.a(this.ac);
      boolean var6 = var3 >= var4 || ai.idealistic.vacan.functionality.c.c.r(this.ac);
      if (var5 == 0) {
         return var6;
      } else if (var6 && this.T <= var1) {
         this.T = System.currentTimeMillis() + (long)var5 * 50L;
         return true;
      } else {
         return false;
      }
   }

   private void a(double var1, int var3, int var4, int var5, int var6, long var7, String var9) {
      String var10 = ai.idealistic.vacan.utils.minecraft.c.a.a(this.ac, ai.idealistic.vacan.functionality.server.a.jb.m("detection_notification").replace("{info}", var9).replace("{detection:level}", (var3 >= var6 ? "§4" : (var3 >= var5 ? "§6" : (var3 >= var4 ? "§3" : "§2"))) + ai.idealistic.vacan.utils.b.a.z((double)var3 / (double)var6 * 100.0D) + "/100"), this.hackType);
      Location var11 = this.ac.getLocation();
      var9 = "(Player: " + this.ac.bC().getName() + "), (" + "Check:" + " " + this.hackType + "), (" + "Java:" + " " + !this.ac.bX() + "), (" + "Detection:" + " " + this.name + "), (Level-Ratio: " + (double)var3 / (double)var6 + "), (Amplitude: " + ai.idealistic.vacan.utils.b.a.e(var1, 2.0D) + "),(" + "Level:" + " " + var3 + "),(" + "Notification-Level:" + " " + var4 + "),(" + "Prevention-Level:" + " " + var5 + "),(" + "Punishment-Level:" + " " + var6 + "),(Server-Version: " + MultiVersion.jf.toString() + "), (Plugin-Version: " + VacanAPI.getVersion() + "), (Silent: " + this.hackType.getCheck().b(this.ac.dr(), this.ac.bV().getName()) + "), (Punish: " + this.hackType.getCheck().a(this.ac.dr()) + "), (Packets: " + this.ac.bW() + "), (Ping: " + this.ac.bS() + "ms), (W-XYZ: " + var11.getWorld().getName() + " " + var11.getBlockX() + " " + var11.getBlockY() + " " + var11.getBlockZ() + "), (Data: " + var9 + ")";
      ai.idealistic.vacan.functionality.d.a.a(this.ac, var10, var9, var3 >= var5, (Material)null, this.hackType, var7);
      if (var3 >= var4) {
         ai.idealistic.vacan.functionality.connection.b.a("checks", this.ac.bT(), this.ac.bC().getName(), var11.getBlockX(), var11.getBlockY(), var11.getBlockZ(), "Detection", var10);
      }

      String var12 = ai.idealistic.vacan.functionality.server.a.iZ.l("Notifications.message_clickable_command").replace("{player}", this.ac.bC().getName());
      if (ai.idealistic.vacan.functionality.server.a.iZ.i("Notifications.individual_only_notifications")) {
         if (this.a(var7, var3, var4)) {
            ai.idealistic.vacan.functionality.c.a.b.a(this.ac.bC(), var10, var12, var12);
         }
      } else {
         List var13 = ai.idealistic.vacan.functionality.c.c.eR();
         if (!var13.isEmpty()) {
            Iterator var14 = var13.iterator();

            while(var14.hasNext()) {
               ai.idealistic.vacan.abstraction.f.c var15 = (ai.idealistic.vacan.abstraction.f.c)var14.next();
               b var16 = var15.a(this.hackType).e(this.name);
               if (var16 != null && var16.a(var7, var3, var4)) {
                  ai.idealistic.vacan.functionality.c.a.b.a(var15.bC(), var10, var12, var12);
               }
            }
         }
      }

   }

   private void a(int var1, int var2) {
      Check var3 = this.hackType.getCheck();
      if (var1 >= var2 && var3.a(this.ac.dr())) {
         List var4 = var3.b();
         if (!var4.isEmpty()) {
            this.R[this.ac.dr().ordinal()] = 0L;
            this.S[this.ac.dr().ordinal()] = -1L;
            int var5 = 0;
            boolean var6 = ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api");
            Iterator var7 = var4.iterator();

            while(var7.hasNext()) {
               String var8 = (String)var7.next();
               String var9 = ai.idealistic.vacan.utils.minecraft.c.a.a((ai.idealistic.vacan.abstraction.f.c)this.ac, var8.replaceAll("\\{detections}|\\{detection}", var3.getName()), (CheckEnums.HackType)null);
               var4.set(var5++, var9);
               if (var6) {
                  Runnable var10 = () -> {
                     PlayerViolationCommandEvent var2 = new PlayerViolationCommandEvent(this.ac.bC(), this.hackType, var9);
                     Bukkit.getPluginManager().callEvent(var2);
                     if (!var2.isCancelled()) {
                        ai.idealistic.vacan.functionality.server.c.R(var9);
                     }

                  };
                  if (ai.idealistic.vacan.functionality.server.c.fe()) {
                     var10.run();
                  } else {
                     ai.idealistic.vacan.functionality.server.c.b(this.ac, var10);
                  }
               } else {
                  ai.idealistic.vacan.functionality.server.c.R(var9);
               }
            }
         }
      }

   }

   public final boolean j() {
      if (this.H.k()) {
         if (ai.idealistic.vacan.functionality.server.c.fe() && ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api")) {
            CheckCancelEvent var1 = new CheckCancelEvent(this.ac.bC(), this.hackType);
            Bukkit.getPluginManager().callEvent(var1);
            if (var1.isCancelled()) {
               return false;
            } else {
               this.H.a(this);
               return true;
            }
         } else {
            this.H.a(this);
            return true;
         }
      } else {
         return false;
      }
   }

   protected Runnable a(Location var1, boolean var2, double var3) {
      return () -> {
         if (var1 != null || var2) {
            if (var1 != null && this.ac.l(var1)) {
               f();
            }

            if (var2 && this.ac.cm()) {
               f();
            }
         }

         if (var3 > 0.0D) {
            this.ac.bC().damage(var3);
         }

      };
   }

   public final void a(double var1, String var3, Location var4, int var5, boolean var6, double var7) {
      if (this.I.n() && this.I.m()) {
         a var9 = this.I.p();
         if (var9 == null || var9.c() || !var9.b(var3)) {
            if (!ai.idealistic.vacan.functionality.connection.e.a(this.ac.dr(), this.hackType.category)) {
               if (this.U <= System.currentTimeMillis() && ai.idealistic.vacan.functionality.server.b.h(this.ac.bC())) {
                  this.U = System.currentTimeMillis() + 2500L;
                  ai.idealistic.vacan.functionality.c.a.M("The '" + this.hackType.category + "' checks are not installed.");
               }

            } else {
               long var10 = System.currentTimeMillis();
               c var12 = new c(var4, var5, var6, var7);
               boolean var13 = ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api");
               a var14 = this.I.q();
               double var15 = Math.min(var1, 1.0D);
               Runnable var17 = () -> {
                  if (var13) {
                     PlayerViolationEvent var9 = new PlayerViolationEvent(this.ac.bC(), this.hackType, var3);
                     Bukkit.getPluginManager().callEvent(var9);
                     if (var9.isCancelled()) {
                        return;
                     }
                  }

                  this.a(var15, var10);
                  ai.idealistic.vacan.functionality.d.d.a(this.hackType, this.ac.dr());
                  int var13x = this.g(this.ac.dr());
                  int var10x = this.e(this.ac.dr());
                  int var11 = this.f(this.ac.dr());
                  int var12x = Math.min(this.d(this.ac.dr()), var13x);
                  this.a(var15, var12x, var10x, var11, var13x, var10, var3);
                  this.H = var12;
                  this.H.V = var12x >= var11 && !this.hackType.getCheck().b(this.ac.dr(), this.ac.bV().getName()) && (var14 == null || var14.c() || !var14.b(var3));
                  if (this.H.l()) {
                     this.j();
                  }

                  this.a(var12x, var13x);
               };
               if (!ai.idealistic.vacan.functionality.server.c.fe() && var13) {
                  ai.idealistic.vacan.functionality.server.c.b(this.ac, var17);
               } else {
                  var17.run();
               }

            }
         }
      }
   }

   public final void a(double var1, String var3, Location var4, int var5, boolean var6) {
      this.a(var1, var3, var4, var5, var6, 0.0D);
   }

   public final void a(String var1, Location var2, int var3, boolean var4) {
      this.a(1.0D, var1, var2, var3, var4, 0.0D);
   }

   public final void a(double var1, String var3, Location var4, int var5) {
      this.a(var1, var3, var4, var5, false, 0.0D);
   }

   public final void a(String var1, Location var2, int var3) {
      this.a(1.0D, var1, var2, var3, false, 0.0D);
   }

   public final void a(double var1, String var3, Location var4) {
      this.a(var1, var3, var4, 0, false, 0.0D);
   }

   public final void a(String var1, Location var2) {
      this.a(1.0D, var1, var2, 0, false, 0.0D);
   }

   public final void a(double var1, String var3) {
      this.a(var1, var3, (Location)null, 0, false, 0.0D);
   }

   public final void c(String var1) {
      this.a(1.0D, var1, (Location)null, 0, false, 0.0D);
   }

   static {
      try {
         v = Bukkit.class.getMethod("getTPS");
      } catch (Exception var1) {
      }

   }
}
