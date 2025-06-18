package ai.idealistic.vacan.abstraction.g;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.listeners.a.a.c;
import ai.idealistic.vacan.utils.minecraft.entity.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

public class b implements Cloneable {
   public static final Location hm = new Location((World)Bukkit.getWorlds().get(0), (double)ai.idealistic.vacan.utils.b.a.g(Integer.MIN_VALUE, Integer.MAX_VALUE), (double)ai.idealistic.vacan.utils.b.a.g(0, 256), (double)ai.idealistic.vacan.utils.b.a.g(Integer.MIN_VALUE, Integer.MAX_VALUE));
   public final World hn;
   private double ho;
   private double hp;
   private double hq;
   private float bu;
   private float bv;

   public static int j(int var0) {
      return var0 >> 4;
   }

   public static Location s(Location var0) {
      return new Location(var0.getWorld(), (double)var0.getBlockX(), (double)var0.getBlockY(), (double)var0.getBlockZ());
   }

   public static double b(Location var0, Location var1) {
      return ai.idealistic.vacan.utils.b.a.b(var0.getX(), var1.getX(), var0.getY(), var1.getY(), var0.getZ(), var1.getZ());
   }

   public static double c(Location var0, Location var1) {
      return ai.idealistic.vacan.utils.b.a.a(var0.getX(), var1.getX(), var0.getY(), var1.getY(), var0.getZ(), var1.getZ());
   }

   private static int a(int var0, int var1, int var2) {
      var0 = 31 * var0 + var1;
      return 31 * var0 + var2;
   }

   public b(World var1, double var2, double var4, double var6, float var8, float var9) {
      this.hn = var1;
      this.ho = var2;
      this.hp = var4;
      this.hq = var6;
      this.bu = var8;
      this.bv = var9;
   }

   public b(World var1, double var2, double var4, double var6) {
      this(var1, var2, var4, var6, 0.0F, 0.0F);
   }

   public b(Location var1) {
      this(var1.getWorld(), var1.getX(), var1.getY(), var1.getZ(), var1.getYaw(), var1.getPitch());
   }

   public b dC() {
      try {
         return (b)super.clone();
      } catch (Exception var2) {
         return null;
      }
   }

   public int dD() {
      return ai.idealistic.vacan.utils.b.a.z(this.ho);
   }

   public int dE() {
      return ai.idealistic.vacan.utils.b.a.z(this.hp);
   }

   public int dF() {
      return ai.idealistic.vacan.utils.b.a.z(this.hq);
   }

   public int dG() {
      return j(this.dD());
   }

   public int dH() {
      return j(this.dF());
   }

   public int dI() {
      return this.dD() & 15;
   }

   public int dJ() {
      return c.jP ? Math.max(this.hn.getMinHeight(), Math.min(this.dE(), this.hn.getMaxHeight())) : Math.max(0, Math.min(this.dE(), d.lz));
   }

   public int dK() {
      return this.dF() & 15;
   }

   public Vector dL() {
      return new Vector(this.ho, this.hp, this.hq);
   }

   public b c(double var1, double var3, double var5) {
      return this.d(-var1, -var3, -var5);
   }

   public b a(b var1) {
      return this.c(var1.dT(), var1.dU(), var1.dV());
   }

   public b t(Location var1) {
      return this.c(var1.getX(), var1.getY(), var1.getZ());
   }

   public b c(Vector var1) {
      return this.c(var1.getX(), var1.getY(), var1.getZ());
   }

   public b d(Vector var1) {
      return this.d(var1.getX(), var1.getY(), var1.getZ());
   }

   public b b(b var1) {
      return this.d(var1.dT(), var1.dU(), var1.dV());
   }

   public b d(double var1, double var3, double var5) {
      Location var7 = (new Location(this.hn, this.ho, this.hp, this.hq)).add(var1, var3, var5);
      this.ho = var7.getX();
      this.hp = var7.getY();
      this.hq = var7.getZ();
      return this;
   }

   private a dM() {
      return new a(this.hn.getBlockAt(this.dD(), this.dE(), this.dF()));
   }

   private a dN() {
      return new a(c.a(this.dR()));
   }

   public a dO() {
      int var1 = this.dE();
      if (c.jP) {
         if (var1 < this.hn.getMinHeight() || var1 > this.hn.getMaxHeight()) {
            return new a(Material.AIR);
         }
      } else if (var1 < 0 || var1 > d.lz) {
         return new a(Material.AIR);
      }

      if (ai.idealistic.vacan.functionality.server.c.bW()) {
         if (ai.idealistic.vacan.functionality.server.c.fe()) {
            return this.dM();
         } else {
            return this.dN();
         }
      } else if (!MultiVersion.jg && !ai.idealistic.vacan.functionality.server.c.fe()) {
         int var2 = this.dG();
         int var3 = this.dH();
         if (this.c(var2, var3)) {
            return this.dM();
         } else {
            return new a((Object)null);
         }
      } else {
         return this.dM();
      }
   }

   private boolean c(int var1, int var2) {
      return c.b(this.hn, var1, var2);
   }

   public boolean dP() {
      return this.c(this.dG(), this.dH());
   }

   public b dQ() {
      b var1 = this.dC();
      var1.w((double)var1.dD());
      var1.x((double)var1.dE());
      var1.y((double)var1.dF());
      return var1;
   }

   public double c(b var1) {
      return ai.idealistic.vacan.utils.b.a.b(this.ho, var1.dT(), this.hp, var1.dU(), this.hq, var1.dV());
   }

   public double d(Block var1) {
      return ai.idealistic.vacan.utils.b.a.b(this.ho, (double)var1.getX(), this.hp, (double)var1.getY(), this.hq, (double)var1.getZ());
   }

   public double d(b var1) {
      return ai.idealistic.vacan.utils.b.a.a(this.ho, var1.dT(), this.hp, var1.dU(), this.hq, var1.dV());
   }

   public double u(Location var1) {
      return ai.idealistic.vacan.utils.b.a.b(this.ho, var1.getX(), this.hp, var1.getY(), this.hq, var1.getZ());
   }

   public Location dR() {
      return new Location(this.hn, this.ho, this.hp, this.hq, this.bu, this.bv);
   }

   public boolean e(b var1) {
      return this.dX() != var1.dX() || this.dW() != var1.dW();
   }

   public boolean a(b var1, boolean var2) {
      boolean var10000;
      if (this.dD() == var1.dD() && this.dF() == var1.dF()) {
         label33: {
            if (var2) {
               if (this.dE() > var1.dE()) {
                  break label33;
               }
            } else if (this.dE() != var1.dE()) {
               break label33;
            }

            var10000 = false;
            return var10000;
         }
      }

      var10000 = true;
      return var10000;
   }

   public BlockFace dS() {
      float var1 = this.dW();
      if (var1 < 0.0F) {
         var1 += 360.0F;
      }

      var1 %= 360.0F;
      switch((int)((double)(var1 + 8.0F) / 22.5D)) {
      case 1:
         return BlockFace.WEST_NORTH_WEST;
      case 2:
         return BlockFace.NORTH_WEST;
      case 3:
         return BlockFace.NORTH_NORTH_WEST;
      case 4:
         return BlockFace.NORTH;
      case 5:
         return BlockFace.NORTH_NORTH_EAST;
      case 6:
         return BlockFace.NORTH_EAST;
      case 7:
         return BlockFace.EAST_NORTH_EAST;
      case 8:
         return BlockFace.EAST;
      case 9:
         return BlockFace.EAST_SOUTH_EAST;
      case 10:
         return BlockFace.SOUTH_EAST;
      case 11:
         return BlockFace.SOUTH_SOUTH_EAST;
      case 12:
         return BlockFace.SOUTH;
      case 13:
         return BlockFace.SOUTH_SOUTH_WEST;
      case 14:
         return BlockFace.SOUTH_WEST;
      case 15:
         return BlockFace.WEST_SOUTH_WEST;
      default:
         return BlockFace.WEST;
      }
   }

   public Collection<b> e(double var1, double var3, double var5) {
      if (!(var1 >= 1.0D) && !(var5 >= 1.0D)) {
         double var7 = 1.0D - var1;
         double var9 = 1.0D - var5;
         if (var1 != var7 && var5 != var9) {
            double var11 = this.dT() - (double)this.dD();
            double var13 = this.dV() - (double)this.dF();
            if (var11 > var1 && var11 < var7 && var13 > var5 && var13 < var9) {
               ArrayList var15 = new ArrayList(2);
               var15.add(this.dC().d(0.0D, var3, 0.0D));
               return var15;
            } else {
               return this.f(var1, var3, var5).values();
            }
         } else {
            return this.f(var1, var3, var5).values();
         }
      } else {
         return this.f(var1, var3, var5).values();
      }
   }

   private Map<Integer, b> f(double var1, double var3, double var5) {
      LinkedHashMap var7 = new LinkedHashMap(10, 1.0F);
      b var8 = this.dC().d(0.0D, var3, 0.0D);
      var7.put(a(var8.dD(), var8.dE(), var8.dF()), var8);
      double[][] var9 = new double[][]{{var1, 0.0D}, {-var1, 0.0D}, {0.0D, var5}, {0.0D, -var5}, {var1, var5}, {-var1, -var5}, {var1, -var5}, {-var1, var5}};
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         double[] var12 = var9[var11];
         b var13 = this.dC().d(var12[0], var3, var12[1]);
         var7.putIfAbsent(a(var13.dD(), var13.dE(), var13.dF()), var13);
      }

      return var7;
   }

   /** @deprecated */
   @Deprecated
   private b[] a(double var1, double var3, double var5, boolean var7) {
      b[] var8;
      if (!(var1 > 0.0D) && !(var5 > 0.0D)) {
         var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D)};
      } else {
         double var9 = this.dT() - (double)this.dD();
         double var11 = this.dV() - (double)this.dF();
         if (!var7) {
            if (var9 >= 0.0D && var9 < 0.3D && var11 >= 0.0D && var11 < 0.3D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(0.0D, var3, -var5), this.dC().d(-var1, var3, 0.0D), this.dC().d(-var1, var3, -var5)};
            } else if (var9 > 0.7D && var9 < 1.0D && var11 >= 0.0D && var11 < 0.3D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(var1, var3, 0.0D), this.dC().d(0.0D, var3, -var5), this.dC().d(var1, var3, -var5)};
            } else if (var9 > 0.7D && var9 < 1.0D && var11 > 0.7D && var11 < 1.0D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(var1, var3, 0.0D), this.dC().d(0.0D, var3, var5), this.dC().d(var1, var3, var5)};
            } else if (var9 >= 0.0D && var9 < 0.3D && var11 > 0.7D && var11 < 1.0D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(-var1, var3, 0.0D), this.dC().d(0.0D, var3, var5), this.dC().d(-var1, var3, var5)};
            } else if (var9 >= 0.0D && var9 < 0.3D && var11 > 0.3D && var11 < 0.7D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(var1, var3, 0.0D)};
            } else if (var9 > 0.7D && var9 < 1.0D && var11 > 0.3D && var11 < 0.7D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(-var1, var3, 0.0D)};
            } else if (var9 > 0.3D && var9 < 0.7D && var11 >= 0.0D && var11 < 0.3D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(0.0D, var3, -var5)};
            } else if (var9 > 0.3D && var9 < 0.7D && var11 > 0.7D && var11 < 1.0D) {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(0.0D, var3, var5)};
            } else {
               var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D)};
            }
         } else {
            var8 = new b[]{var3 == 0.0D ? this : this.dC().d(0.0D, var3, 0.0D), this.dC().d(var1, var3, 0.0D), this.dC().d(-var1, var3, 0.0D), this.dC().d(0.0D, var3, var5), this.dC().d(0.0D, var3, -var5), this.dC().d(var1, var3, var5), this.dC().d(-var1, var3, -var5), this.dC().d(var1, var3, -var5), this.dC().d(-var1, var3, var5)};
         }
      }

      return var8;
   }

   @Generated
   public World bV() {
      return this.hn;
   }

   @Generated
   public double dT() {
      return this.ho;
   }

   @Generated
   public double dU() {
      return this.hp;
   }

   @Generated
   public double dV() {
      return this.hq;
   }

   @Generated
   public float dW() {
      return this.bu;
   }

   @Generated
   public float dX() {
      return this.bv;
   }

   @Generated
   public void w(double var1) {
      this.ho = var1;
   }

   @Generated
   public void x(double var1) {
      this.hp = var1;
   }

   @Generated
   public void y(double var1) {
      this.hq = var1;
   }

   @Generated
   public void a(float var1) {
      this.bu = var1;
   }

   @Generated
   public void b(float var1) {
      this.bv = var1;
   }

   @Generated
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         if (!var2.e((Object)this)) {
            return false;
         } else if (Double.compare(this.dT(), var2.dT()) != 0) {
            return false;
         } else if (Double.compare(this.dU(), var2.dU()) != 0) {
            return false;
         } else if (Double.compare(this.dV(), var2.dV()) != 0) {
            return false;
         } else if (Float.compare(this.dW(), var2.dW()) != 0) {
            return false;
         } else if (Float.compare(this.dX(), var2.dX()) != 0) {
            return false;
         } else {
            World var3 = this.bV();
            World var4 = var2.bV();
            if (var3 == null) {
               if (var4 != null) {
                  return false;
               }
            } else if (!var3.equals(var4)) {
               return false;
            }

            return true;
         }
      }
   }

   @Generated
   protected boolean e(Object var1) {
      return var1 instanceof b;
   }

   @Generated
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      long var3 = Double.doubleToLongBits(this.dT());
      int var10 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = Double.doubleToLongBits(this.dU());
      var10 = var10 * 59 + (int)(var5 >>> 32 ^ var5);
      long var7 = Double.doubleToLongBits(this.dV());
      var10 = var10 * 59 + (int)(var7 >>> 32 ^ var7);
      var10 = var10 * 59 + Float.floatToIntBits(this.dW());
      var10 = var10 * 59 + Float.floatToIntBits(this.dX());
      World var9 = this.bV();
      var10 = var10 * 59 + (var9 == null ? 43 : var9.hashCode());
      return var10;
   }

   @Generated
   public String toString() {
      return "ServerLocation(world=" + this.bV() + ", x=" + this.dT() + ", y=" + this.dU() + ", z=" + this.dV() + ", yaw=" + this.dW() + ", pitch=" + this.dX() + ")";
   }

   // $FF: synthetic method
   public Object clone() {
      return this.dC();
   }
}
