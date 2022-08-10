<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />

    <footer id="footer" class="text-center">
      {{ new Date().getFullYear() }} —
      <strong>Cincinnati Local Looks</strong>
    </footer>
  </div>
</template>

<style scoped>
.text-center {
  text-align: center;
}

#nav {
  border-bottom: 1px solid black;
  padding: 1rem;
  margin-bottom: 2rem;
  display: flex;
  justify-content: space-around;
}

a {
  text-decoration: none;
  color: black;
  position: relative;
}

a::before {
  transform: scaleX(0);
  transform-origin: bottom right;
}

a:hover::before {
  transform: scaleX(1);
  transform-origin: bottom left;
}

a::before {
  content: " ";
  display: block;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  inset: 0 0 0 0;
  background: rgb(238, 130, 238);
  z-index: -1;
  transition: transform 0.3s ease;
}

#footer {
  border-top: 1px solid black;
  padding: 1rem;
  margin-top: 180px;
  position: relative;
  width: 100%;
  bottom: 0;
  height: 50px;
}
</style>