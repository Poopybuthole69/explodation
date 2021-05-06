
package net.mcreator.explodation.item;

@ExplodationModElements.ModElement.Tag
public class SaphireSwordItem extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:saphire_sword")
	public static final Item block = null;

	public SaphireSwordItem(ExplodationModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("saphire_sword"));
	}

}
