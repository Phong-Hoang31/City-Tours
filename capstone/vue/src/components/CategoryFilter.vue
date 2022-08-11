<template>
  <div></div>
</template>

<script>
export default {
  name: "category-filter",
  computed: {
    filteredLandmarks() {
      const reviewsFilter = this.$store.state.filter;
      const reviews = this.$store.state.reviews;
      return reviews.filter((review) => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>