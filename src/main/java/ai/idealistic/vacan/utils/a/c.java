package ai.idealistic.vacan.utils.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class c<K, V> implements Map<K, V> {
   private final Map<K, V> iP;
   private final int ka;

   public c(Map<K, V> var1, int var2) {
      this.iP = var1;
      this.ka = var2;
   }

   public int size() {
      return this.iP.size();
   }

   public boolean isEmpty() {
      return this.iP.isEmpty();
   }

   public boolean containsKey(Object var1) {
      return this.iP.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.iP.containsValue(var1);
   }

   public V get(Object var1) {
      return this.iP.get(var1);
   }

   @Nullable
   public V put(K var1, V var2) {
      Object var3 = this.iP.put(var1, var2);
      if (var3 == null && this.iP.size() > this.ka) {
         Iterator var4 = this.iP.keySet().iterator();
         var4.next();
         var4.remove();
      }

      return var3;
   }

   public V remove(Object var1) {
      return this.iP.remove(var1);
   }

   public void putAll(@NotNull Map<? extends K, ? extends V> var1) {
      if (var1 == null) {
         d(0);
      }

      throw new UnsupportedOperationException();
   }

   public void clear() {
      this.iP.clear();
   }

   @NotNull
   public Set<K> keySet() {
      Set var10000 = this.iP.keySet();
      if (var10000 == null) {
         d(1);
      }

      return var10000;
   }

   @NotNull
   public Collection<V> values() {
      Collection var10000 = this.iP.values();
      if (var10000 == null) {
         d(2);
      }

      return var10000;
   }

   @NotNull
   public Set<Entry<K, V>> entrySet() {
      Set var10000 = this.iP.entrySet();
      if (var10000 == null) {
         d(3);
      }

      return var10000;
   }

   public V putIfAbsent(K var1, V var2) {
      Object var3 = this.get(var1);
      if (var3 == null) {
         var3 = this.put(var1, var2);
      }

      return var3;
   }

   public V computeIfAbsent(K var1, @NonNull Function<? super K, ? extends V> var2) {
      Objects.requireNonNull(var2);
      Object var3;
      Object var4;
      if ((var3 = this.get(var1)) == null && (var4 = var2.apply(var1)) != null) {
         this.put(var1, var4);
         return var4;
      } else {
         return var3;
      }
   }

   public V computeIfPresent(K var1, @NonNull BiFunction<? super K, ? super V, ? extends V> var2) {
      Objects.requireNonNull(var2);
      Object var3;
      if ((var3 = this.get(var1)) != null) {
         Object var4 = var2.apply(var1, var3);
         if (var4 != null) {
            this.put(var1, var4);
            return var4;
         } else {
            this.remove(var1);
            return null;
         }
      } else {
         return null;
      }
   }

   public V compute(K var1, @NonNull BiFunction<? super K, ? super V, ? extends V> var2) {
      Objects.requireNonNull(var2);
      Object var3 = this.get(var1);
      Object var4 = var2.apply(var1, var3);
      if (var4 == null) {
         this.c(var1, var3);
      } else {
         this.put(var1, var4);
      }

      return var4;
   }

   public void c(K var1, V var2) {
      if (var2 != null || this.containsKey(var1)) {
         this.remove(var1);
      }

   }

   public V merge(K var1, @NonNull V var2, @NonNull BiFunction<? super V, ? super V, ? extends V> var3) {
      Objects.requireNonNull(var3);
      Objects.requireNonNull(var2);
      Object var4 = this.get(var1);
      Object var5 = var4 == null ? var2 : var3.apply(var4, var2);
      if (var5 == null) {
         this.remove(var1);
      } else {
         this.put(var1, var5);
      }

      return var5;
   }

   // $FF: synthetic method
   private static void d(int var0) {
      String var10000;
      switch(var0) {
      case 0:
      default:
         var10000 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
         break;
      case 1:
      case 2:
      case 3:
         var10000 = "@NotNull method %s.%s must not return null";
      }

      byte var10001;
      switch(var0) {
      case 0:
      default:
         var10001 = 3;
         break;
      case 1:
      case 2:
      case 3:
         var10001 = 2;
      }

      Object[] var2 = new Object[var10001];
      switch(var0) {
      case 0:
      default:
         var2[0] = "m";
         break;
      case 1:
      case 2:
      case 3:
         var2[0] = "ai/idealistic/vacan/utils/java/OverflowMap";
      }

      switch(var0) {
      case 0:
      default:
         var2[1] = "ai/idealistic/vacan/utils/java/OverflowMap";
         break;
      case 1:
         var2[1] = "keySet";
         break;
      case 2:
         var2[1] = "values";
         break;
      case 3:
         var2[1] = "entrySet";
      }

      switch(var0) {
      case 0:
      default:
         var2[2] = "putAll";
      case 1:
      case 2:
      case 3:
         var10000 = String.format(var10000, var2);
         Object var1;
         String var4;
         switch(var0) {
         case 0:
         default:
            IllegalArgumentException var3 = new IllegalArgumentException;
            var4 = var10000;
            var1 = var3;
            var3.<init>(var4);
            break;
         case 1:
         case 2:
         case 3:
            IllegalStateException var10002 = new IllegalStateException;
            var4 = var10000;
            var1 = var10002;
            var10002.<init>(var4);
         }

         throw var1;
      }
   }
}
