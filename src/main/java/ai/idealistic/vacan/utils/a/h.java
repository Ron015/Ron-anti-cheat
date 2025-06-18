package ai.idealistic.vacan.utils.a;

import lombok.Generated;

public final class h {
   public static String t(long var0) {
      long var2 = 1000L;
      long var4 = 60000L;
      long var6 = 3600000L;
      long var8 = 86400000L;
      long var10 = 604800000L;
      double var12 = 30.44D;
      double var14 = 365.25D;
      long var16 = 2630016000L;
      long var18 = 31557600000L;
      long var22 = var0 / 31557600000L;
      long var20 = var0 % 31557600000L;
      long var24 = var20 / 2630016000L;
      var20 %= 2630016000L;
      long var26 = var20 / 604800000L;
      var20 %= 604800000L;
      long var28 = var20 / 86400000L;
      var20 %= 86400000L;
      long var30 = var20 / 3600000L;
      var20 %= 3600000L;
      long var32 = var20 / 60000L;
      var20 %= 60000L;
      long var34 = var20 / 1000L;
      StringBuilder var36 = new StringBuilder();
      if (var22 > 0L) {
         var36.append(var22).append("y ");
      }

      if (var24 > 0L) {
         var36.append(var24).append("m ");
      }

      if (var26 > 0L) {
         var36.append(var26).append("w ");
      }

      if (var28 > 0L) {
         var36.append(var28).append("d ");
      }

      if (var30 > 0L) {
         var36.append(var30).append("h ");
      }

      if (var32 > 0L) {
         var36.append(var32).append("m ");
      }

      if (var34 > 0L || var36.length() == 0) {
         var36.append(var34).append("s ");
      }

      return var36.toString().trim();
   }

   @Generated
   private h() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
