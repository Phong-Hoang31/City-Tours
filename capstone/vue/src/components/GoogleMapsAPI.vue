<template>
  <GmapMap ref="mapRef" ...>
    <GmapMarker ref="myMarker" :position="google && new google.maps.LatLng(1.38, 103.8)" />
  </GmapMap>
</template>
<script>
import { getGoogleMapsAPI } from 'gmap-vue';

export default {
  name: 'google-maps-api',
  computed: {
    // The below example is the same as writing
    // google() {
    //   return getGoogleMapsAPI();
    // },
    google: getGoogleMapsAPI,
  },
};
</script>