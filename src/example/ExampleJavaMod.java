package example;

import mindustry.mod.Mod;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.meta.BuildVisibility;
import arc.graphics.Color;

public class ExampleJavaMod extends Mod {
    public static BeamDrill myDrill;

    @Override
    public void loadContent() {
        // 👈 内部 ID 直接写中文！不写 localizedName 了，因为默认就用这个显示
        myDrill = new BeamDrill("高能等离子钻机");
        
        myDrill.size = 2;
        myDrill.health = 320;
        myDrill.tier = 3;
        myDrill.range = 5;
        myDrill.drillTime = 96f;
        myDrill.itemCapacity = 10;
        myDrill.liquidCapacity = 10;
        myDrill.category = Category.production;
        
        // 沙盒直接显示
        myDrill.buildVisibility = BuildVisibility.shown;
        
        // 造价与耗电
        myDrill.requirements(Category.production, ItemStack.with(Items.silicon, 20, Items.beryllium, 30));
        myDrill.consumePower(1.5f);

        // 原版完美泛光组件
        DrawGlowRegion glow = new DrawGlowRegion();
        glow.alpha = 0.9f;
        glow.color = Color.valueOf("F79D9B"); // 珊瑚粉
        glow.glowIntensity = 0.5f;
        glow.glowScale = 10f;

        myDrill.drawer = new DrawMulti(new DrawDefault(), glow);
    }
}
