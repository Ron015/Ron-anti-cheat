package ai.idealistic.vacan.abstraction.profiling;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.f.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class b {
   private final a fT;
   private final Map<Long, Long>[] gd;

   public b(a var1) {
      this.fT = var1;
      this.gd = new Map[Check.DataType.values().length];
      Check.DataType[] var2 = Check.DataType.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Check.DataType var5 = var2[var4];
         this.gd[var5.ordinal()] = new ConcurrentHashMap();
      }

   }

   public void clear() {
      Map[] var1 = this.gd;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Map var4 = var1[var3];
         var4.clear();
      }

   }

   public void a(long var1, long var3, boolean var5) {
      if (var5) {
         ai.idealistic.vacan.functionality.d.a.a(var1, this.fT.name + " was active for: " + var3, false, true, true);
      }

      this.gd[this.fT.bv().ordinal()].put(var1, var3);
   }

   public boolean a(long var1, long var3) {
      c var5 = this.fT.bt();
      if (var5 != null && var1 >= var5.ct() && var3 >= var5.ct()) {
         return !var5.cb();
      } else {
         Map var6 = this.gd[(var5 == null ? this.fT.bv() : var5.dr()).ordinal()];
         if (!var6.isEmpty()) {
            Iterator var7 = var6.entrySet().iterator();

            while(var7.hasNext()) {
               Entry var8 = (Entry)var7.next();
               long var9 = (Long)var8.getValue();
               long var11 = (Long)var8.getKey();
               if (var3 >= var11 - var9 && var1 <= var11) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean bx() {
      c var1 = this.fT.bt();
      return !this.gd[(var1 == null ? this.fT.bv() : var1.dr()).ordinal()].isEmpty();
   }

   public long by() {
      c var1 = this.fT.bt();
      long var2 = 0L;
      Map var4 = this.gd[(var1 == null ? this.fT.bv() : var1.dr()).ordinal()];
      long var6;
      if (!var4.isEmpty()) {
         for(Iterator var5 = var4.values().iterator(); var5.hasNext(); var2 += var6) {
            var6 = (Long)var5.next();
         }
      }

      return var1 != null && !var1.cb() ? var1.bE() + var2 : var2;
   }
}
