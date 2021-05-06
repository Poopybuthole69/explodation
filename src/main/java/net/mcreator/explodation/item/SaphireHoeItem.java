
package net.mcreator.explodation.item;

@ExplodationModElements.ModElement.Tag
public class SaphireHoeItem extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:saphire_hoe")
	public static final Item block = null;

	public SaphireHoeItem(ExplodationModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, 0, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("saphire_hoe"));
	}

}
