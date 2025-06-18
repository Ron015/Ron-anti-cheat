package ai.idealistic.vacan.abstraction.check;

import ai.idealistic.vacan.compatibility.Compatibility;
import lombok.Generated;

public class a {
   private final String r;
   private final String s;
   private final long t;

   a(Compatibility.CompatibilityType var1) {
      this.r = var1.toString();
      this.s = null;
      this.t = 0L;
   }

   a(String var1, String var2, int var3) {
      this.r = var1;
      this.s = var2;
      this.t = var3 == 0 ? Long.MAX_VALUE : System.currentTimeMillis() + (long)var3 * 50L;
   }

   boolean c() {
      return this.t < System.currentTimeMillis();
   }

   boolean b(String var1) {
      return this.s == null || var1.contains(this.s);
   }

   @Generated
   public String d() {
      return this.r;
   }

   @Generated
   public String e() {
      return this.s;
   }
}
