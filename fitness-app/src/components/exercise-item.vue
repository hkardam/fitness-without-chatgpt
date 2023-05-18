<template>
    <div class="row mb-2">
        <div class="col-2">{{ index + 1 }}</div>
        <div class="col-4">
            <select v-if="editMode" class="form-select" v-model="form.name">
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
                <option>E</option>
            </select>
            <span v-else>{{ exercise.name }}</span>
        </div>
        <div class="col-2">
            <input v-if="editMode" class="form-control" v-model.number="form.sets" type="number" step="1" min="0"
                placeholder="3" />
            <span v-else>{{ exercise.sets }}</span>
        </div>
        <div class="col-2">
            <input v-if="editMode" class="form-control" v-model.number="form.rep" type="number" step="1" min="0"
                placeholder="3" />
            <span v-else>{{ exercise.rep }}</span>
        </div>
        <div class="col-2">
            <button v-if="editMode" class="btn btn-sm btn-success" @click="saveExercise">
                <b-icon icon="check"></b-icon>
            </button>
            <button v-else @click="editMode = true" class="btn btn-sm btn-primary">
                <b-icon icon="pencil"></b-icon>
            </button>
            <span class="px-1"></span>
            <button class="btn btn-sm btn-danger" @click="removeExercise">
                <b-icon icon="trash"></b-icon>
            </button>
        </div>
    </div>
</template>

<script>
import { updateExercise, deleteExercise } from '../api';
export default {
    name: "ExerciseItem",
    props: {
        index: Number,
        exercise: Object,
    },
    data() {
        return {
            form: {},
            editMode: false,
        };
    },
    watch: {
        exercise(val) {
            console.log('exercise watcher: ', val);
            this.form = { ...val };
        },
    },
    methods: {
        saveExercise() {
            console.log(this.form);
            updateExercise(this.form)
            .then((resp) => {
                console.log(resp);
                this.$store.commit('updateExercise', this.form);
                this.editMode = false;
            })
            .catch((err) => {
                this.editMode = false;
                console.log(err);
            });
        },
        removeExercise() {
            console.log("deleting ", this.exercise.id);
            deleteExercise(this.exercise.id)
            .then((resp) => {
                console.log(resp);
                this.$store.commit('removeExercise', this.exercise.id);
            })
            .catch((err) => {
                console.log(err);
            });
        },
    },
    beforeMount() {
        this.form = { ...this.exercise };
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
