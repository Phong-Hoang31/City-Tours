<template>
  <div id="app">
    <div id="nav" v-if="$store.state.token != ''">
      <router-link v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'itineraries' }"
        >MY ITINERARIES</router-link
      >&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }">LOGOUT</router-link>
    </div>
    <div id="nav" v-else>
      <router-link v-bind:to="{ name: 'home' }">HOME</router-link>
    </div>
    <router-view />

    <footer id="footer" class="text-center">
      {{ new Date().getFullYear() }} —
      <strong>Cincinnati Local Looks</strong>
    </footer>
  </div>
</template>

<style scoped>
#app {
  width: 100%;
}
.text-center {
  text-align: center;
}

#nav {
  box-shadow: 0px 1px 5000px 5px rgb(170, 112, 195);
  padding: 2rem;
  margin-bottom: 2rem;
  display: flex;
  justify-content: space-around;
  align-items: center;
  font-size: 2.5rem;
  text-align: center;
}

a {
  text-decoration: none;
  color: black;
  position: relative;
  letter-spacing: 0.75rem;
  font-size: 1rem;
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
  background: rgb(170, 112, 195);
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