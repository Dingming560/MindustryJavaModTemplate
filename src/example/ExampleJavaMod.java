package example;

import mindustry.mod.Mod;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.meta.BuildVisibility;
import arc.graphics.Color;

public class ExampleJavaMod extends Mod {
    public static BeamDrill myDrill;

    @Override
    public void loadContent() {
        myDrill = new BeamDrill("plasma-drill");
        
        myDrill.localizedName = "高能等离子钻机";
        
        myDrill.size = 2;
        myDrill.health = 320;
        myDrill.tier = 3;
        myDrill.range = 5;
        myDrill.drillTime = 96f;
        myDrill.itemCapacity = 10;
        myDrill.liquidCapacity = 10;
        myDrill.category = Category.production;
        
        myDrill.buildVisibility = BuildVisibility.shown;
        
        myDrill.requirements(Category.production, ItemStack.with(Items.silicon, 20, Items.beryllium, 30));
        myDrill.consumePower(1.5f);

        // 🌟 核心：控制方块本体发光层的颜色！
        // 原版那种温暖的亮橙色/黄橙色
        myDrill.glowColor = Color.valueOf("ffcc33"); 
        
        // 如果你想让泛光更亮、更明显，可以顺便加一句：
        // myDrill.lightColor = Color.valueOf("ffcc33");
    }
}
