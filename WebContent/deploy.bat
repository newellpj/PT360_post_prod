
copy C:\Users\newelly\git\PersonnelTrackerPostProd\target\PersonnelTracker.war . /y
jar uvf PersonnelTracker.war WEB-INF\classes\*
move PersonnelTracker.war c:\backup\
pause