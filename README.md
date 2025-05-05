For this project, I’m building a task manager specifically geared toward college students. The idea came from my own frustration trying to keep up with assignments, due dates, and random to-dos across different courses. Canvas and other apps are either too rigid or disorganized, so I wanted to make something lightweight but visually organized, a kind of daily dashboard where tasks are grouped by class and sorted by due date.

The UMD Task Manager is an app with JavaFX that gives users an overview of their tasks and deadlines. You can add a task, give it a due date, and assign it to a class. Tasks show up on a dashboard view, sorted by class in columns and with a sidebar for Today’s Tasks. There are buttons to complete or remove each task, and the UI updates automatically when you do.

I’m using the MVP pattern to keep things organized and modular. Here’s how the program breaks down:

Model: Task, Course, and TaskManager. These handle the data and logic like adding, completing, and sorting tasks.

View: DashboardView and TaskCard are the main parts of the UI. Most things are styled with CSS and organized into panes for classes, today’s tasks, and some extra stuff like a greeting and quote.

Presenter: The Presenter connects the view and the model. It takes care of getting data from the TaskManager and telling the view what to display.

Others: There's a FileReader interface and a test implementation so I could fake some tasks while building the UI. Eventually, I'd want this to support saving and loading real files.

I like this idea because it's practical and solves a real problem I deal with. It also gave me a reason to dive deeper into JavaFX and try to get better at the MVP model. The way I set things up makes it easy to expand later like adding new features for syncing with a calendar, saving tasks to disk, or even building a mobile version down the line.

If I had more time, I’d like to:

Add a class management feature with data like professors and office hours

Let users drag tasks around or filter them by date

Make the UI more colorful and clean

Save everything between sessions

Overall, this project has been a fun way to combine good software design with something useful. It’s a tool I’d honestly use myself

