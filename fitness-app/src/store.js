import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const state = {
    exerciseList: [
        { id: 1, name: "A", sets: 3, rep: 10 },
        { id: 2, name: "B", sets: 4, rep: 12 },
        { id: 3, name: "C", sets: 5, rep: 8 },
    ],
};

const getters = {
    evenOrOdd: (state) => (state.count % 2 === 0 ? "even" : "odd"),
    exerciseList: (state) => state.exerciseList
};

const mutations = {
    setList(state, exerciseList) {
        state.exerciseList = [...exerciseList];
    },
    addExercise(state, payload) {
        state.exerciseList.push(payload);
    },
    removeExercise(state, id) {
        const index = state.exerciseList.findIndex(e => e.id == id);
        if (index != -1) {
            state.exerciseList.splice(index, 1);
        }
    },
    updateExercise(state, payload) {
        const index = state.exerciseList.findIndex(e => e.id == payload.id);
        if (index != -1) {
            state.exerciseList.splice(index, 1, payload);
        }
    }
};

const actions = {
    increment: ({ commit }) => commit('increment'),
    decrement: ({ commit }) => commit('decrement'),
    incrementIfOdd({ commit, state }) {
        if ((state.count + 1) % 2 === 0) {
            commit('increment')
        }
    },
    incrementAsync({ commit }) {
        return new Promise((resolve) => {
            setTimeout(() => {
                commit('increment')
                resolve()
            }, 1000)
        })
    }
}

export default new Vuex.Store({
    state,
    getters,
    mutations,
    actions
});
