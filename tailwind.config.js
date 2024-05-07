/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/templates/**/*.{html,js}"],
  theme: {
      extend: {
          colors: {
              "primary":"#30336b",
              "secondary": "#f0932b",
              "accent": "#ff7979",
              "neutral": "#f0932b",
              "base-100": "#f5f6fa"
          }
      }
  }
    ,
  theme: {
    extend: {},
  },
  plugins: [
      require("@tailwindcss/typography"),
      require('@tailwindcss/forms')]
}

