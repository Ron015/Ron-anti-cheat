package ai.idealistic.vacan.utils.minecraft.world;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import lombok.Generated;

public enum EnumFacing {
   DOWN("DOWN", 0, 0, 1, -1, "down", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Y, new ai.idealistic.vacan.utils.minecraft.d.d(0, -1, 0)),
   UP("UP", 1, 1, 0, -1, "up", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Y, new ai.idealistic.vacan.utils.minecraft.d.d(0, 1, 0)),
   NORTH("NORTH", 2, 2, 3, 2, "north", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Z, new ai.idealistic.vacan.utils.minecraft.d.d(0, 0, -1)),
   SOUTH("SOUTH", 3, 3, 2, 0, "south", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Z, new ai.idealistic.vacan.utils.minecraft.d.d(0, 0, 1)),
   WEST("WEST", 4, 4, 5, 1, "west", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.X, new ai.idealistic.vacan.utils.minecraft.d.d(-1, 0, 0)),
   EAST("EAST", 5, 5, 4, 3, "east", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.X, new ai.idealistic.vacan.utils.minecraft.d.d(1, 0, 0));

   private final int index;
   private final int opposite;
   private final int horizontalIndex;
   private final String name;
   private final EnumFacing.Axis axis;
   private final EnumFacing.AxisDirection axisDirection;
   private final ai.idealistic.vacan.utils.minecraft.d.d directionVec;
   public static final EnumFacing[] VALUES = new EnumFacing[6];
   private static final EnumFacing[] HORIZONTALS = new EnumFacing[4];
   private static final Map NAME_LOOKUP = Maps.newHashMap();
   private static final EnumFacing[] $VALUES = new EnumFacing[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};

   private EnumFacing(String var3, int var4, int var5, int var6, int var7, String var8, EnumFacing.AxisDirection var9, EnumFacing.Axis var10, ai.idealistic.vacan.utils.minecraft.d.d var11) {
      this.index = var5;
      this.horizontalIndex = var7;
      this.opposite = var6;
      this.name = var8;
      this.axis = var10;
      this.axisDirection = var9;
      this.directionVec = var11;
   }

   public EnumFacing getOpposite() {
      return VALUES[this.opposite];
   }

   public EnumFacing rotateAround(EnumFacing.Axis var1) {
      switch(var1) {
      case X:
         if (this != WEST && this != EAST) {
            return this.rotateX();
         }

         return this;
      case Y:
         if (this != UP && this != DOWN) {
            return this.rotateY();
         }

         return this;
      case Z:
         if (this != NORTH && this != SOUTH) {
            return this.rotateZ();
         }

         return this;
      default:
         throw new IllegalStateException("Unable to get CW facing for axis " + var1);
      }
   }

   public EnumFacing rotateY() {
      switch(this) {
      case NORTH:
         return EAST;
      case EAST:
         return SOUTH;
      case SOUTH:
         return WEST;
      case WEST:
         return NORTH;
      default:
         throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   private EnumFacing rotateX() {
      switch(this) {
      case NORTH:
         return DOWN;
      case EAST:
      case WEST:
      default:
         throw new IllegalStateException("Unable to get X-rotated facing of " + this);
      case SOUTH:
         return UP;
      case UP:
         return NORTH;
      case DOWN:
         return SOUTH;
      }
   }

   private EnumFacing rotateZ() {
      switch(this) {
      case EAST:
         return DOWN;
      case SOUTH:
      default:
         throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
      case WEST:
         return UP;
      case UP:
         return EAST;
      case DOWN:
         return WEST;
      }
   }

   public EnumFacing rotateYCCW() {
      switch(this) {
      case NORTH:
         return WEST;
      case EAST:
         return NORTH;
      case SOUTH:
         return EAST;
      case WEST:
         return SOUTH;
      default:
         throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   public int getFrontOffsetX() {
      return this.axis == EnumFacing.Axis.X ? this.axisDirection.getOffset() : 0;
   }

   public int getFrontOffsetY() {
      return this.axis == EnumFacing.Axis.Y ? this.axisDirection.getOffset() : 0;
   }

   public int getFrontOffsetZ() {
      return this.axis == EnumFacing.Axis.Z ? this.axisDirection.getOffset() : 0;
   }

   public String getName2() {
      return this.name;
   }

   public static EnumFacing byName(String var0) {
      return var0 == null ? null : (EnumFacing)NAME_LOOKUP.get(var0.toLowerCase());
   }

   public static EnumFacing getFront(int var0) {
      return VALUES[ai.idealistic.vacan.utils.b.c.p(var0 % VALUES.length)];
   }

   public static EnumFacing getHorizontal(int var0) {
      return HORIZONTALS[ai.idealistic.vacan.utils.b.c.p(var0 % HORIZONTALS.length)];
   }

   public static EnumFacing fromAngle(double var0) {
      return getHorizontal(ai.idealistic.vacan.utils.b.c.I(var0 / 90.0D + 0.5D) & 3);
   }

   public static EnumFacing random(Random var0) {
      return values()[var0.nextInt(values().length)];
   }

   public static EnumFacing func_176737_a(float var0, float var1, float var2) {
      EnumFacing var3 = NORTH;
      float var4 = Float.MIN_VALUE;
      EnumFacing[] var5 = values();
      int var6 = var5.length;
      EnumFacing[] var7 = var5;
      int var8 = var5.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumFacing var10 = var7[var9];
         float var11 = var0 * (float)var10.directionVec.fK() + var1 * (float)var10.directionVec.fL() + var2 * (float)var10.directionVec.fM();
         if (var11 > var4) {
            var4 = var11;
            var3 = var10;
         }
      }

      return var3;
   }

   public String toString() {
      return this.name;
   }

   @Generated
   public int getIndex() {
      return this.index;
   }

   @Generated
   public int getHorizontalIndex() {
      return this.horizontalIndex;
   }

   @Generated
   public String getName() {
      return this.name;
   }

   @Generated
   public EnumFacing.Axis getAxis() {
      return this.axis;
   }

   @Generated
   public EnumFacing.AxisDirection getAxisDirection() {
      return this.axisDirection;
   }

   @Generated
   public ai.idealistic.vacan.utils.minecraft.d.d getDirectionVec() {
      return this.directionVec;
   }

   // $FF: synthetic method
   private static EnumFacing[] $values() {
      return new EnumFacing[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
   }

   static {
      EnumFacing[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumFacing var3 = var0[var2];
         VALUES[var3.index] = var3;
         if (var3.getAxis().isHorizontal()) {
            HORIZONTALS[var3.horizontalIndex] = var3;
         }

         NAME_LOOKUP.put(var3.getName2().toLowerCase(), var3);
      }

   }

   public static enum Axis implements Predicate {
      X("X", 0, "X", 0, "x", EnumFacing.Plane.HORIZONTAL),
      Y("Y", 1, "Y", 1, "y", EnumFacing.Plane.VERTICAL),
      Z("Z", 2, "Z", 2, "z", EnumFacing.Plane.HORIZONTAL);

      private static final Map NAME_LOOKUP = Maps.newHashMap();
      private final String name;
      private final EnumFacing.Plane plane;
      private static final EnumFacing.Axis[] $VALUES = new EnumFacing.Axis[]{X, Y, Z};
      private static final EnumFacing.Axis[] $VALUES$ = new EnumFacing.Axis[]{X, Y, Z};

      private Axis(String var3, int var4, String var5, int var6, String var7, EnumFacing.Plane var8) {
         this.name = var7;
         this.plane = var8;
      }

      public static EnumFacing.Axis byName(String var0) {
         return var0 == null ? null : (EnumFacing.Axis)NAME_LOOKUP.get(var0.toLowerCase());
      }

      public String getName2() {
         return this.name;
      }

      public boolean isVertical() {
         return this.plane == EnumFacing.Plane.VERTICAL;
      }

      public boolean isHorizontal() {
         return this.plane == EnumFacing.Plane.HORIZONTAL;
      }

      public String toString() {
         return this.name;
      }

      public boolean apply(EnumFacing var1) {
         return var1 != null && var1.getAxis() == this;
      }

      public boolean apply(Object var1) {
         return this.apply((EnumFacing)var1);
      }

      @Generated
      public String getName() {
         return this.name;
      }

      @Generated
      public EnumFacing.Plane getPlane() {
         return this.plane;
      }

      // $FF: synthetic method
      private static EnumFacing.Axis[] $values() {
         return new EnumFacing.Axis[]{X, Y, Z};
      }

      static {
         EnumFacing.Axis[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            EnumFacing.Axis var3 = var0[var2];
            NAME_LOOKUP.put(var3.getName2().toLowerCase(), var3);
         }

      }
   }

   public static enum AxisDirection {
      POSITIVE("POSITIVE", 0, "POSITIVE", 0, 1, "Towards positive"),
      NEGATIVE("NEGATIVE", 1, "NEGATIVE", 1, -1, "Towards negative");

      private final int offset;
      private final String description;
      private static final EnumFacing.AxisDirection[] $VALUES = new EnumFacing.AxisDirection[]{POSITIVE, NEGATIVE};

      private AxisDirection(String var3, int var4, String var5, int var6, int var7, String var8) {
         this.offset = var7;
         this.description = var8;
      }

      public int getOffset() {
         return this.offset;
      }

      public String toString() {
         return this.description;
      }

      // $FF: synthetic method
      private static EnumFacing.AxisDirection[] $values() {
         return new EnumFacing.AxisDirection[]{POSITIVE, NEGATIVE};
      }
   }

   static final class a {
      static final int[] nu;
      static final int[] nv;
      static final int[] nw = new int[EnumFacing.Plane.values().length];

      static {
         try {
            nw[EnumFacing.Plane.HORIZONTAL.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            nw[EnumFacing.Plane.VERTICAL.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         nv = new int[EnumFacing.values().length];

         try {
            nv[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            nv[EnumFacing.EAST.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            nv[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            nv[EnumFacing.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var6) {
         }

         try {
            nv[EnumFacing.UP.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            nv[EnumFacing.DOWN.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
         }

         nu = new int[EnumFacing.Axis.values().length];

         try {
            nu[EnumFacing.Axis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            nu[EnumFacing.Axis.Y.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            nu[EnumFacing.Axis.Z.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
         }

      }
   }

   public static enum Plane implements Predicate, Iterable {
      HORIZONTAL("HORIZONTAL", 0, "HORIZONTAL", 0),
      VERTICAL("VERTICAL", 1, "VERTICAL", 1);

      private static final EnumFacing.Plane[] $VALUES = new EnumFacing.Plane[]{HORIZONTAL, VERTICAL};

      private Plane(String var3, int var4, String var5, int var6) {
      }

      public EnumFacing[] facings() {
         switch(EnumFacing.a.nw[this.ordinal()]) {
         case 1:
            return new EnumFacing[]{EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST};
         case 2:
            return new EnumFacing[]{EnumFacing.UP, EnumFacing.DOWN};
         default:
            throw new Error("Someone's been tampering with the universe!");
         }
      }

      public EnumFacing random(Random var1) {
         EnumFacing[] var2 = this.facings();
         return var2[var1.nextInt(var2.length)];
      }

      public boolean apply(EnumFacing var1) {
         return var1 != null && var1.getAxis().getPlane() == this;
      }

      public Iterator iterator() {
         return Iterators.forArray(this.facings());
      }

      public boolean apply(Object var1) {
         return this.apply((EnumFacing)var1);
      }

      // $FF: synthetic method
      private static EnumFacing.Plane[] $values() {
         return new EnumFacing.Plane[]{HORIZONTAL, VERTICAL};
      }
   }
}
