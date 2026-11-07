package example;

import mindustry.mod.Mod;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.meta.BuildVisibility;

public class ExampleJavaMod extends Mod {
    public static BeamDrill myDrill;

    @Override
    public void loadContent() {
        // 1. 纯英文内部 ID，让图集打包器闭嘴
        myDrill = new BeamDrill("plasma-drill");
        
        // 2. 游戏 UI 显示纯中文，强制干掉前缀！
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
    }
}
