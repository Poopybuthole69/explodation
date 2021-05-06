
package net.mcreator.explodation.item;

@ExplodationModElements.ModElement.Tag
public class SaphireItem extends ExplodationModElements.ModElement {

	@ObjectHolder("explodation:saphire")
	public static final Item block = null;

	public SaphireItem(ExplodationModElements instance) {
		super(instance, 12);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("saphire");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
