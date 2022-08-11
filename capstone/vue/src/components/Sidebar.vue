<template>
  <div>

  </div>
</template>

<script>
export default {
  name: "SidebarDisplay",
   data: () => ({
      drawer: false,
      group: null,
    }),

    watch: {
      group () {
        this.drawer = false
      },
    },
};
</script>

<style lang="scss" scoped>
</style>