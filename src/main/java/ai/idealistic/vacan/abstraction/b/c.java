package ai.idealistic.vacan.abstraction.b;

import java.util.Map;

public class c {
   private final Map<String, Long> eL;

   public c(Map<String, Long> var1) {
      this.eL = var1;
   }

   public int y(String var1) {
      Long var2 = (Long)this.eL.get(var1);
      if (var2 == null) {
         return 0;
      } else {
         var2 = var2 - System.currentTimeMillis();
         return var2 < 0L ? 0 : ai.idealistic.vacan.utils.b.a.B((double)var2 / 50.0D);
      }
   }

   public boolean t(String var1) {
      return this.y(var1) == 0;
   }

   public void g(String var1, int var2) {
      this.eL.put(var1, System.currentTimeMillis() + (long)var2 * 50L);
   }

   public void a(String[] var1, int var2) {
      String[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         this.eL.put(var6, System.currentTimeMillis() + (long)var2 * 50L);
      }

   }

   public void u(String var1) {
      this.eL.remove(var1);
   }

   public void a(String[] var1) {
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.eL.remove(var5);
      }

   }
}
