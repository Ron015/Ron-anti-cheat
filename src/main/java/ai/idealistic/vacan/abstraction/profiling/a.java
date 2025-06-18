package ai.idealistic.vacan.abstraction.profiling;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.abstraction.f.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;

public class a {
   public static final String fX = " was active for: ";
   public final String name;
   private final MiningHistory[] fY;
   private ItemStack fZ;
   private OfflinePlayer fp;
   private Check.DataType ga;
   private final b gb;
   private final Map<String, List<Long>>[][] gc;

   public a(String var1) {
      this.name = var1;
      this.fZ = null;
      this.fY = new MiningHistory[MiningHistory.MiningOre.values().length];
      this.ga = Check.DataType.JAVA;
      this.gb = new b(this);
      this.gc = new Map[CheckEnums.HackType.values().length][Check.DataType.values().length];
      CheckEnums.HackType[] var2 = CheckEnums.HackType.values();
      int var3 = var2.length;

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         CheckEnums.HackType var5 = var2[var4];
         Check.DataType[] var6 = Check.DataType.values();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Check.DataType var9 = var6[var8];
            this.gc[var5.ordinal()][var9.ordinal()] = new ConcurrentHashMap(1);
         }
      }

      MiningHistory.MiningOre[] var10 = MiningHistory.MiningOre.values();
      var3 = var10.length;

      for(var4 = 0; var4 < var3; ++var4) {
         MiningHistory.MiningOre var12 = var10[var4];
         this.fY[var12.ordinal()] = new MiningHistory(this, var12);
      }

      c var11 = ai.idealistic.vacan.functionality.server.c.P(var1);
      if (var11 != null) {
         this.fp = var11.bC();
      } else {
         this.fp = null;
      }

   }

   public a(c var1) {
      this.name = var1.bC().getName();
      this.fp = var1.bC();
      this.fZ = null;
      this.fY = new MiningHistory[MiningHistory.MiningOre.values().length];
      this.ga = var1.dr();
      this.gb = new b(this);
      this.gc = new Map[CheckEnums.HackType.values().length][Check.DataType.values().length];
      CheckEnums.HackType[] var2 = CheckEnums.HackType.values();
      int var3 = var2.length;

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         CheckEnums.HackType var5 = var2[var4];
         Check.DataType[] var6 = Check.DataType.values();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Check.DataType var9 = var6[var8];
            this.gc[var5.ordinal()][var9.ordinal()] = new ConcurrentHashMap(1);
         }
      }

      MiningHistory.MiningOre[] var10 = MiningHistory.MiningOre.values();
      var3 = var10.length;

      for(var4 = 0; var4 < var3; ++var4) {
         MiningHistory.MiningOre var11 = var10[var4];
         this.fY[var11.ordinal()] = new MiningHistory(this, var11);
      }

   }

   public void h(c var1) {
      this.fp = var1.bC();
      this.ga = var1.dr();
   }

   c bt() {
      return ai.idealistic.vacan.functionality.server.c.Q(this.name);
   }

   public e a(CheckEnums.HackType var1) {
      c var2 = this.bt();
      return var2 == null ? null : var2.a(var1);
   }

   public ItemStack bu() {
      if (this.fZ == null) {
         return this.fp == null ? ai.idealistic.vacan.utils.minecraft.a.c.b((OfflinePlayer)null, this.name, false) : (this.fZ = ai.idealistic.vacan.utils.minecraft.a.c.b(this.fp, this.name, false));
      } else {
         return this.fZ;
      }
   }

   public MiningHistory a(MiningHistory.MiningOre var1) {
      return this.fY[var1.ordinal()];
   }

   public List<Long> a(CheckEnums.HackType var1, Check.DataType var2, String var3) {
      List var4 = (List)this.gc[var1.ordinal()][var2.ordinal()].get(var3);
      if (var4 == null) {
         return new ArrayList(0);
      } else {
         if (!var4.isEmpty()) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               Long var6 = (Long)var5.next();
               if (var6 < 0L) {
                  var4.remove(var6);
                  var4.add(Math.abs(var6));
               }
            }
         }

         return var4;
      }
   }

   public void a(CheckEnums.HackType var1, Check.DataType var2, String var3, List<Long> var4) {
      List var5 = (List)this.gc[var1.ordinal()][var2.ordinal()].computeIfAbsent(var3, (var0) -> {
         return new ai.idealistic.vacan.utils.a.a();
      });
      var5.clear();
      var5.addAll(var4);
   }

   public void a(CheckEnums.HackType var1, Check.DataType var2, String var3, long var4) {
      List var6 = (List)this.gc[var1.ordinal()][var2.ordinal()].computeIfAbsent(var3, (var0) -> {
         return new ai.idealistic.vacan.utils.a.a();
      });
      int var7 = var6.size() - 1024;
      if (var7 > 0) {
         Iterator var8 = var6.iterator();

         while(var8.hasNext() && var7 > 0) {
            if (var6.remove(var8.next())) {
               --var7;
            }
         }
      }

      var6.add(var4);
   }

   public void b(CheckEnums.HackType var1, Check.DataType var2, String var3) {
      List var4 = (List)this.gc[var1.ordinal()][var2.ordinal()].get(var3);
      if (var4 != null) {
         var4.clear();
      }

   }

   public final void b(CheckEnums.HackType var1, String var2) {
      Check.DataType[] var3 = Check.DataType.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Check.DataType var6 = var3[var5];
         List var7 = (List)this.gc[var1.ordinal()][var6.ordinal()].get(var2);
         if (var7 != null && !var7.isEmpty()) {
            Collections.sort(var7);
            Iterator var8 = var7.iterator();
            if (var8.hasNext()) {
               ArrayList var9 = new ArrayList(var7.size() - 1);
               long var10 = (Long)var8.next();

               while(var8.hasNext()) {
                  long var12 = (Long)var8.next();
                  if (var12 >= 0L) {
                     if (var10 >= 0L) {
                        if (this.bw().a(var12, var10)) {
                           var9.add(var12 - var10);
                        }

                        var10 = var12;
                     }
                  } else {
                     var9.add(Math.abs(var12));
                  }
               }

               this.a(var1, var6, var2, var9);
            }
         }
      }

   }

   @Generated
   public Check.DataType bv() {
      return this.ga;
   }

   @Generated
   public void h(Check.DataType var1) {
      this.ga = var1;
   }

   @Generated
   public b bw() {
      return this.gb;
   }
}
