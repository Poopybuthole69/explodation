
package net.mcreator.explodation.item;

@ExplodationModElements.ModElement.Tag
public class SaphirePickaxeItem extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:saphire_pickaxe")
	public static final Item block = null;

	public SaphirePickaxeItem(ExplodationModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SaphireItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("saphire_pickaxe"));
	}

}
