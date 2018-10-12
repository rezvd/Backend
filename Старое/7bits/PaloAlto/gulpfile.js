var gulp = require('gulp');
var sass = require('gulp-sass');
var compileHandlebars = require('gulp-compile-handlebars');
var handlebars = require('gulp-handlebars');
var rename = require('gulp-rename');
var browserSync = require('browser-sync').create();
var wrap = require('gulp-wrap');
var declare = require('gulp-declare');
var nunjucks = require('gulp-nunjucks');
var concat = require('gulp-concat');
var cssmin = require('gulp-cssmin');
var uglify = require('gulp-uglify');
var autoprefixer = require('gulp-autoprefixer');

var path = {
    css:  './src/*.scss',
    hbs: {
        pages: './src/pages/**/*.hbs',
        templates: './src/templates/**/*.hbs',
        partials: './src/partials/'
    },
    vendor: {
        js: './src/vendor/js/*.js'
    },
    mockapi: './src/mockapi/*.json',
    js: './src/scripts/*.js',
    images: './src/images/*.*',
    dist: {
        css:  './dist/styles/',
        js: './dist/',
        html: './dist/',
        partials: './dist/partials/',
        images: './dist/images/',
        mockapi: './dist/mockapi/',
        vendor: {
            js: './dist/'
        },
        templates: './dist/'
    }
};

gulp.task('default', ['build', 'serve', 'watch']);

gulp.task('hbs_templates', function() {
    return gulp.src(path.hbs.templates)
        .pipe(handlebars({
            handlebars: require('handlebars')
        }))
        .pipe(wrap('Handlebars.template(<%= contents %>)'))
        .pipe(declare({
            namespace: 'blocks.templates',
            noRedeclare: true
        }))
        .pipe(concat('templates.js'))
        .pipe(gulp.dest(path.dist.templates))
});



gulp.task('css', function () {
    return gulp.src(path.css)
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest(path.dist.css));
});


gulp.task('vendor_js', function () {
    return gulp.src(path.vendor.js)
        .pipe(concat('vendor.js'))
        .pipe(gulp.dest(path.dist.vendor.js));
});

gulp.task('css-min', function () {
    return gulp.src(path.css)
        .pipe(autoprefixer({
            browsers: ['last 4 versions']
        }))
        .pipe(concat('style.css'))
        .pipe(cssmin())
        .pipe(gulp.dest(path.dist.css));
});


gulp.task('js', function () {
    return gulp.src(path.js)
        .pipe(concat('scripts.js'))
        .pipe(gulp.dest(path.dist.js));
});

gulp.task('js-min', function () {
    return gulp.src(path.js)
        .pipe(concat('scripts.js'))
        .pipe(uglify())
        .pipe(gulp.dest(path.dist.js));
});

gulp.task('html', function () {
    return gulp.src(path.hbs.pages)
        .pipe(compileHandlebars({}, {
            ignorePartials: true,
            batch: [path.hbs.partials]
        }))
        .pipe(rename({
            dirname: '.',
            extname: '.html'
        }))
        .pipe(gulp.dest(path.dist.html));
});


gulp.task('partials', function () {
    return gulp.src(path.hbs.partials)
        .pipe(rename({
            dirname: '.',
            extname: '.html'
        }))
        .pipe(gulp.dest(path.dist.partials));
});

gulp.task('images', function () {
    return gulp.src(path.images)
        .pipe(gulp.dest(path.dist.images));
});


gulp.task('mockapi', function () {
    return gulp.src(path.mockapi)
        .pipe(gulp.dest(path.dist.mockapi));
});

gulp.task('build', [
    'html',
    'css',
    'js',
    'hbs_templates',
    'mockapi',
    'vendor_js',
    'images']);

gulp.task('watch', function () {
    gulp.watch(path.css, ['css']);
    gulp.watch(path.js, ['js']);
    gulp.watch(path.mockapi, ['mockapi']);
    gulp.watch(path.partials, ['partials']);
});

gulp.task('serve', ['watch'], function() {
    browserSync.init({
        server: {
            baseDir: path.dist.html
        }
    });
    gulp.watch('dist/**').on('change', browserSync.reload);
});