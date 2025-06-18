package ai.idealistic.vacan.abstraction.check.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.b;
import ai.idealistic.vacan.abstraction.check.e;

public class a extends b {
   public a(e var1, Check.DataType var2, Check.DetectionType var3, String var4, Boolean var5) {
      super(var1, var2, var3, var4, var5);
   }

   public a(e var1, Check.DataType var2, Check.DetectionType var3, String var4, Boolean var5, long var6, long var8, long var10, long var12) {
      super(var1, var2, var3, var4, var5, var6, var8, var10, var12);
   }

   public a(b var1, String var2, Boolean var3) {
      super(var1.I, var1.L, var1.M, var2, var3, var1.N, var1.O, var1.P, var1.Q);
      if (!var1.J) {
         var1.I.b(var1);
         var1.I.hackType.removeDetection(var1.name);
      }

   }

   public a(b var1, String var2, Boolean var3, long var4, long var6, long var8, long var10) {
      super(var1.I, var1.L, var1.M, var2, var3, var4, var6, var8, var10);
      if (!var1.J) {
         var1.I.b(var1);
         var1.I.hackType.removeDetection(var1.name);
      }

   }
}
