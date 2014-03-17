package exter.foundry.material;

public class OreDictMaterial
{
  
  public final String suffix;
  public final String default_prefix;
  
  private OreDictMaterial(String mat_suffix,String mat_default_prefix)
  {
    suffix = mat_suffix;
    default_prefix = mat_default_prefix;
  }
  
  static public final OreDictMaterial[] MATERIALS = new OreDictMaterial[] {
    new OreDictMaterial("Aluminum","ingot"),
    new OreDictMaterial("Carbon","dust"),
    new OreDictMaterial("Chromium","ingot"),
    new OreDictMaterial("Cobalt","ingot"),
    new OreDictMaterial("Copper","ingot"),
    new OreDictMaterial("Gold","ingot"),
    new OreDictMaterial("Iron","ingot"),
    new OreDictMaterial("Lead","ingot"),
    new OreDictMaterial("Manganese","ingot"),
    new OreDictMaterial("Nickel","ingot"),
    new OreDictMaterial("Osmium","ingot"),
    new OreDictMaterial("Platinum","ingot"),
    new OreDictMaterial("Silver","ingot"),
    new OreDictMaterial("Tin","ingot"),
    new OreDictMaterial("Titanium","ingot"),
    new OreDictMaterial("Tungsten","ingot"),
    new OreDictMaterial("Uranium","ingot"),
    new OreDictMaterial("Zinc","ingot"),
    new OreDictMaterial("Stone","ingot"),
    new OreDictMaterial("Gunpowder","dust"),
    new OreDictMaterial("Wood","planks"),
    new OreDictMaterial("Endstone","block"),
    new OreDictMaterial("Netherrack","block"),
    new OreDictMaterial("Amethyst","gem"),
    new OreDictMaterial("Brass","ingot"),
    new OreDictMaterial("Bronze","ingot"),
    new OreDictMaterial("Cobaltite","dust"),
    new OreDictMaterial("Cupronickel","ingot"),
    new OreDictMaterial("Diamond","gem"),
    new OreDictMaterial("Electrum","ingot"),
    new OreDictMaterial("Emerald","gem"),
    new OreDictMaterial("GreenSapphire","gem"),
    new OreDictMaterial("Invar","ingot"),
    new OreDictMaterial("Kanthal","ingot"),
    new OreDictMaterial("Nichrome","ingot"),
    new OreDictMaterial("Obsidian","dust"),
    new OreDictMaterial("Olivine","gem"),
    new OreDictMaterial("Ruby","gem"),
    new OreDictMaterial("Sapphire","gem"),
    new OreDictMaterial("StainlessSteel","ingot"),
    new OreDictMaterial("Steel","ingot"),
    new OreDictMaterial("Topaz","gem"),
    new OreDictMaterial("Redstone","dust"),
    new OreDictMaterial("Glowstone","dust")
  };
}
