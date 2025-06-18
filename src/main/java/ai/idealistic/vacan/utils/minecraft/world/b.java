package ai.idealistic.vacan.utils.minecraft.world;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

public class b extends ai.idealistic.vacan.utils.minecraft.d.d {
   public static final b lY = new b(0, 0, 0);
   private static final int lZ = 1 + ai.idealistic.vacan.utils.b.c.t(ai.idealistic.vacan.utils.b.c.q(30000000));
   private static final int mb;
   private static final int mc;
   private static final int md;
   private static final int mf;
   private static final long mg;
   private static final long mh;
   private static final long mi;

   public b(int var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public b(double var1, double var3, double var5) {
      super(var1, var3, var5);
   }

   public b(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      this(var1.lR, var1.lS, var1.lT);
   }

   public b(ai.idealistic.vacan.utils.minecraft.d.d var1) {
      this(var1.fK(), var1.fL(), var1.fM());
   }

   public b t(double var1, double var3, double var5) {
      return new b((double)this.fK() + var1, (double)this.fL() + var3, (double)this.fM() + var5);
   }

   public b e(int var1, int var2, int var3) {
      return new b(this.fK() + var1, this.fL() + var2, this.fM() + var3);
   }

   public b d(ai.idealistic.vacan.utils.minecraft.d.d var1) {
      return new b(this.fK() + var1.fK(), this.fL() + var1.fL(), this.fM() + var1.fM());
   }

   public b e(ai.idealistic.vacan.utils.minecraft.d.d var1) {
      return new b(this.fK() - var1.fK(), this.fL() - var1.fL(), this.fM() - var1.fM());
   }

   public b y(int var1) {
      return new b(this.fK() * var1, this.fL() * var1, this.fM() * var1);
   }

   public b fN() {
      return this.z(1);
   }

   public b z(int var1) {
      return this.a(EnumFacing.UP, var1);
   }

   public b fO() {
      return this.A(1);
   }

   public b A(int var1) {
      return this.a(EnumFacing.DOWN, var1);
   }

   public b fP() {
      return this.B(1);
   }

   public b B(int var1) {
      return this.a(EnumFacing.NORTH, var1);
   }

   public b fQ() {
      return this.C(1);
   }

   public b C(int var1) {
      return this.a(EnumFacing.SOUTH, var1);
   }

   public b fR() {
      return this.D(1);
   }

   public b D(int var1) {
      return this.a(EnumFacing.WEST, var1);
   }

   public b fS() {
      return this.E(1);
   }

   public b E(int var1) {
      return this.a(EnumFacing.EAST, var1);
   }

   public b a(EnumFacing var1) {
      return this.a(var1, 1);
   }

   public b a(EnumFacing var1, int var2) {
      return new b(this.fK() + var1.getFrontOffsetX() * var2, this.fL() + var1.getFrontOffsetY() * var2, this.fM() + var1.getFrontOffsetZ() * var2);
   }

   public b f(ai.idealistic.vacan.utils.minecraft.d.d var1) {
      return new b(this.fL() * var1.fM() - this.fM() * var1.fL(), this.fM() * var1.fK() - this.fK() * var1.fM(), this.fK() * var1.fL() - this.fL() * var1.fK());
   }

   public long fT() {
      return ((long)this.fK() & mg) << mf | ((long)this.fL() & mh) << md | (long)this.fM() & mi;
   }

   public static b u(long var0) {
      int var2 = (int)(var0 << 64 - mf - lZ >> 64 - lZ);
      int var3 = (int)(var0 << 64 - md - mc >> 64 - mc);
      int var4 = (int)(var0 << 64 - mb >> 64 - mb);
      return new b(var2, var3, var4);
   }

   public static Iterable a(b var0, b var1) {
      final b var2 = new b(Math.min(var0.fK(), var1.fK()), Math.min(var0.fL(), var1.fL()), Math.min(var0.fM(), var1.fM()));
      final b var3 = new b(Math.max(var0.fK(), var1.fK()), Math.max(var0.fL(), var1.fL()), Math.max(var0.fM(), var1.fM()));
      return new Iterable() {
         public Iterator iterator() {
            return new AbstractIterator() {
               private b ml = null;

               protected b fU() {
                  if (this.ml == null) {
                     this.ml = var2;
                     return this.ml;
                  } else if (this.ml.equals(var3)) {
                     return (b)this.endOfData();
                  } else {
                     int var1 = this.ml.fK();
                     int var2x = this.ml.fL();
                     int var3x = this.ml.fM();
                     if (var1 < var3.fK()) {
                        ++var1;
                     } else if (var2x < var3.fL()) {
                        var1 = var2.fK();
                        ++var2x;
                     } else if (var3x < var3.fM()) {
                        var1 = var2.fK();
                        var2x = var2.fL();
                        ++var3x;
                     }

                     this.ml = new b(var1, var2x, var3x);
                     return this.ml;
                  }
               }

               protected Object computeNext() {
                  return this.fU();
               }
            };
         }
      };
   }

   public static Iterable b(b var0, b var1) {
      final b var2 = new b(Math.min(var0.fK(), var1.fK()), Math.min(var0.fL(), var1.fL()), Math.min(var0.fM(), var1.fM()));
      final b var3 = new b(Math.max(var0.fK(), var1.fK()), Math.max(var0.fL(), var1.fL()), Math.max(var0.fM(), var1.fM()));
      return new Iterable() {
         public Iterator iterator() {
            return new AbstractIterator() {
               private b.a mn = null;

               protected b.a fV() {
                  if (this.mn == null) {
                     this.mn = new b.a(var2.fK(), var2.fL(), var2.fM(), (Object)null);
                     return this.mn;
                  } else if (this.mn.equals(var3)) {
                     return (b.a)this.endOfData();
                  } else {
                     int var1 = this.mn.fK();
                     int var2x = this.mn.fL();
                     int var3x = this.mn.fM();
                     if (var1 < var3.fK()) {
                        ++var1;
                     } else if (var2x < var3.fL()) {
                        var1 = var2.fK();
                        ++var2x;
                     } else if (var3x < var3.fM()) {
                        var1 = var2.fK();
                        var2x = var2.fL();
                        ++var3x;
                     }

                     this.mn.lV = var1;
                     this.mn.lW = var2x;
                     this.mn.lX = var3x;
                     return this.mn;
                  }
               }

               protected Object computeNext() {
                  return this.fV();
               }
            };
         }
      };
   }

   public ai.idealistic.vacan.utils.minecraft.d.d b(ai.idealistic.vacan.utils.minecraft.d.d var1) {
      return this.f(var1);
   }

   static {
      mb = lZ;
      mc = 64 - lZ - mb;
      md = mb;
      mf = md + mc;
      mg = (1L << lZ) - 1L;
      mh = (1L << mc) - 1L;
      mi = (1L << mb) - 1L;
   }

   public static final class a extends b {
      public int lV;
      public int lW;
      public int lX;

      private a(int var1, int var2, int var3) {
         super(0, 0, 0);
         this.lV = var1;
         this.lW = var2;
         this.lX = var3;
      }

      public int fK() {
         return this.lV;
      }

      public int fL() {
         return this.lW;
      }

      public int fM() {
         return this.lX;
      }

      public ai.idealistic.vacan.utils.minecraft.d.d b(ai.idealistic.vacan.utils.minecraft.d.d var1) {
         return super.f(var1);
      }

      a(int var1, int var2, int var3, Object var4) {
         this(var1, var2, var3);
      }
   }
}
