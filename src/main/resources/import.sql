--
-- JBoss, Home of Professional Open Source
-- Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Trips (id, name, descr, tdate, edate, sloc, dloc, miles, vehi, tinfo, attends, atype, cuser, cdate, muser, mdate) values (0, 'Fall City trip', 'Hwy 9 - Hwy 2 - Hwy 203 - Hwy 202 - Back home.', '2016-08-14 10:30:00', '2016-08-14 12:45:00', 'Bothell, WA', 'Fall City, WA', 80, 'Yamaha FJ-09', 'Drove thru the back roads in Duvall.', 'solo trip', 'Touring', 'GaneshR', '2016-08-18 11:50:00', 'GaneshR','2016-08-18 11:50:00')