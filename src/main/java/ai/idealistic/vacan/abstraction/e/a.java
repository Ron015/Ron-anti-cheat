package ai.idealistic.vacan.abstraction.e;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.api.Permission;
import ai.idealistic.vacan.functionality.server.b;
import java.util.List;
import java.util.Objects;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class a {
   protected String fG;
   protected final Permission[] fH;
   protected ItemStack fI;
   protected ClickType fJ;
   protected int fK;
   protected int fL;
   protected Inventory fM;

   public a(String var1, int var2, Permission[] var3) {
      this.fG = var1;
      this.fI = null;
      this.fJ = null;
      this.fM = null;
      this.fK = 0;
      this.fL = var2;
      this.fH = var3;
   }

   public a(String var1, int var2, Permission var3) {
      this(var1, var2, new Permission[]{var3});
   }

   protected Inventory a(c var1, String var2, int var3) {
      this.fG = var2;
      this.fL = var3;
      return this.fM = var1.b(var3, var2);
   }

   protected Inventory a(c var1, int var2) {
      this.fL = var2;
      return this.fM = var1.b(var2, this.fG);
   }

   protected Inventory a(c var1, String var2) {
      this.fG = var2;
      return this.fM = var1.b(this.fL, var2);
   }

   protected void a(String var1, List<String> var2, ItemStack var3, int var4) {
      ai.idealistic.vacan.utils.minecraft.a.c.a(this.fM, var1, var2, var3, var4);
   }

   public boolean a(c var1, boolean var2) {
      return this.a(var1, var2, (Object)null);
   }

   public boolean a(c var1, Object var2) {
      return this.a(var1, true, var2);
   }

   public boolean e(c var1) {
      return this.a(var1, true, (Object)null);
   }

   public boolean a(c var1, boolean var2, Object var3) {
      boolean var4;
      if (this.fH.length == 0) {
         var4 = true;
      } else {
         boolean var5 = false;
         Permission[] var6 = this.fH;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Permission var9 = var6[var8];
            if (b.a(var1.bC(), var9)) {
               var5 = true;
               break;
            }
         }

         var4 = var5;
      }

      if (var4) {
         this.fM = var1.b(this.fL, this.fG);
         if (this.b(var1, var2, var3)) {
            ai.idealistic.vacan.functionality.server.c.b(var1, () -> {
               var1.bC().openInventory(this.fM);
            });
            return true;
         } else {
            return false;
         }
      } else {
         if (var2) {
            var1.bC().sendMessage(ai.idealistic.vacan.functionality.server.a.jb.m("no_permission"));
         }

         Player var10001 = var1.bC();
         Objects.requireNonNull(var10001);
         ai.idealistic.vacan.functionality.server.c.b(var1, var10001::closeInventory);
         return false;
      }
   }

   protected abstract boolean b(c var1, boolean var2, Object var3);

   public boolean a(c var1, String var2, ItemStack var3, ClickType var4, int var5) {
      if (var2.equals(this.fG)) {
         boolean var6;
         if (this.fH.length == 0) {
            var6 = true;
         } else {
            boolean var7 = false;
            Permission[] var8 = this.fH;
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               Permission var11 = var8[var10];
               if (b.a(var1.bC(), var11)) {
                  var7 = true;
                  break;
               }
            }

            var6 = var7;
            if (!var7) {
               var1.bC().closeInventory();
            }
         }

         if (var6) {
            this.fI = var3;
            this.fJ = var4;
            this.fK = var5;
            return this.f(var1);
         }
      }

      return false;
   }

   protected abstract boolean f(c var1);
}
