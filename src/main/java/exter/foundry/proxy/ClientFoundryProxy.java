package exter.foundry.proxy;

import java.util.List;

import cpw.mods.fml.client.registry.RenderingRegistry;
import exter.foundry.integration.ModIntegration;
import exter.foundry.item.FoundryItems;
import exter.foundry.material.MaterialRegistry;
import exter.foundry.material.OreDictMaterial;
import exter.foundry.material.OreDictType;
import exter.foundry.recipes.manager.InfuserRecipeManager;
import exter.foundry.renderer.RendererItemContainer;
import exter.foundry.renderer.RendererRefractoryHopper;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;

public class ClientFoundryProxy extends CommonFoundryProxy
{
  static private ResourceLocation SUBSTANCES_TEXTURE = new ResourceLocation("foundry:textures/gui/infuser_substances.png");

  static public int hopper_renderer_id;
  
  @Override
  public void PreInit()
  {
    MaterialRegistry.instance.InitIcons();
    InfuserRecipeManager.instance.InitTextures();
    ModIntegration.ClientPreInit();
  }

  @Override
  public void Init()
  {
    MinecraftForgeClient.registerItemRenderer(FoundryItems.item_container, new RendererItemContainer());
    InfuserRecipeManager.instance.RegisterSubstanceTexture("carbon", SUBSTANCES_TEXTURE, 0, 0);
    int i;
    for(i = 0; i < ItemDye.field_150921_b/* icon_names */.length; i++)
    {
      InfuserRecipeManager.instance.RegisterSubstanceTexture("dye." + ItemDye.field_150921_b/* icon_names */[i], SUBSTANCES_TEXTURE, 8, 0, ItemDye.field_150922_c/* colors */[i]);
    }
    
    
    hopper_renderer_id = RenderingRegistry.getNextAvailableRenderId();
    RenderingRegistry.registerBlockHandler(hopper_renderer_id,new RendererRefractoryHopper());
    
    ModIntegration.ClientInit();
  }

  @Override
  public void PostInit()
  {
    for(OreDictMaterial material : OreDictMaterial.MATERIALS)
    {
      List<ItemStack> ores = OreDictionary.getOres(material.default_prefix + material.suffix);
      if(ores.size() > 0)
      {
        MaterialRegistry.instance.RegisterMaterialIcon(material.suffix, ores.get(0));
      } else
      {
        for(OreDictType type : OreDictType.TYPES)
        {
          ores = OreDictionary.getOres(type.prefix + material.suffix);
          if(ores.size() > 0)
          {
            MaterialRegistry.instance.RegisterMaterialIcon(material.suffix, ores.get(0));
            break;
          }
        }
      }
    }

    for(OreDictType type : OreDictType.TYPES)
    {
      List<ItemStack> ores = OreDictionary.getOres(type.prefix + type.default_suffix);
      if(ores.size() > 0)
      {
        MaterialRegistry.instance.RegisterTypeIcon(type.name, ores.get(0));
      } else
      {
        for(OreDictMaterial material : OreDictMaterial.MATERIALS)
        {
          ores = OreDictionary.getOres(type.prefix + material.suffix);
          if(ores.size() > 0)
          {
            MaterialRegistry.instance.RegisterTypeIcon(type.name, ores.get(0));
            break;
          }
        }
      }
    }
    ModIntegration.ClientPostInit();
  }

}
