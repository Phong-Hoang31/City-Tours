import axios from 'axios';

export default {

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary)
    },

    getAllItineraries() {
        return axios.get('/itineraries')
    },

    addLandmarkToItinerary(itineraryId, landmarkId) {
        return axios.post(`/itineraries/${itineraryId}/${landmarkId}`)
    },

    deleteLandmarkFromItinerary(itineraryId, landmarkId) {
        return axios.delete(`/itineraries/${itineraryId}/${landmarkId}`)
    },

    updateItineraryName(itineraryId, itinerary) {
        return axios.put(`/itineraries/${itineraryId}`, itinerary)
    },

    deleteItinerary(itineraryId) {
        return axios.delete(`/itineraries/${itineraryId}`)
    },

    incrementLandmarkOrder(itineraryId, landmarkOrder) {
        return axios.put(`/ itineraries / ${itineraryId} / ${landmarkOrder} / increment`)
    },

    decrementLandmarkOrder(itineraryId, landmarkOrder) {
        return axios.put(`/ itineraries / ${itineraryId} / ${landmarkOrder} / decrement`)
    },

}