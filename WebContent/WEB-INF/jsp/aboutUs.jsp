<div class="aboutUsSpiel responsive"><p>Personnel Tracker is an evolving
			organisational performance tracking
			system built using AngularJS, Java 8, Spring, Hibernate,
			MySQL and Solr. It aims to streamline the process of improving your
			employees performance and enabling better managerial decision making
			backed by structured data. It also aims to give users the ability to publish
			this information to third parties if it so chooses or the public in general with
			 application administration built-in function. If you wish to know more
			 please contact us using the contact form provided here. </p> </div>
          <div class="culture responsive">
					   <img src="./presentationResources/images/culture.jpg">
					</div>
					<div class="quote1 responsive">
					         &quot;This system signficantly cuts down on the time wasted with paper based system and empowers
									 employees to take a leading role in their performance improvement process - <b>John Taylor HZX</b> &quot;
					</div>
					<div class="culture2 responsive">
						  <img src="./presentationResources/images/culture2.jpg">
					</div>
					<div class="quote2 responsive">
					         &quot;Removes a fair degree of subjectivity from the performance review process and increases employee satisfaction - <b>Mike Williams YZA</b> &quot;
					</div>

			 <div>
      <form name="contactForm" validate class="contactForm responsive" required ng-init="contactDetEmail = '';  contactDetPhone='';
				 contactDetName =''; contactDetMessage='';">

			        <!-- NAME -->
							  <h3>Make an Enquiry</h3>
							 	<div class="contactImg responsive"><img src="./presentationResources/images/contactUsImg.jpg" /></div>
							  <input type="text" name="contactDetName" id="contactDetName" ng-model="contactDetName" placeholder="First name [Required]" required />
										<div class="errorName responsive" ng-messages="contactForm.contactDetName.$error">
										  <div ng-hide="contactForm.contactDetName.$valid || !contactForm.$dirty" >This field is required</div>
										</div>
							  <input type="email" name="contactDetEmail" id="contactDetEmail" ng-model="contactDetEmail"  placeholder="Email [Required]" required />
										<div class="errorEmail responsive" ng-messages="contactForm.contactDetEmail.$error">
											<div ng-hide="contactForm.contactDetEmail.$valid || !contactForm.$dirty" >A valid email is required</div>
										</div>
							  <input type="email" name="contactDetPhone" id="contactDetPhone" ng-model="contactDetPhone" placeholder="Contact number" />
							  <textarea rows="6" type="text" name="contactDetMessage" id="contactDetMessage" ng-model="contactDetMessage" placeholder="Enquiry [Required]" required></textarea>
										<div class="errorEnq resposive" ng-messages="contactForm.contactDetMessage.$error">
											<div ng-hide="contactForm.contactDetMessage.$valid  || !contactForm.$dirty">This field is required</div>
										</div>
								 <div id="waiter2" class="ajax-loader-2a waiter2a responsive"><div style="float:right; min-width:160px; margin-top:35%;">Sending enquiry...</div></div>
                   <div id="successErrorMsg" class="successErrorMsg responsive"></div>

								<button id="submitEnquiry" name="submit" type="button"  style="box-shadow: 3px 3px 10px #252728 ;" ng-click="submitEnquiry()"
									class="contactUs responsive" value="Contact us" ng-disabled="!contactForm.contactDetName.$valid  ||
									                                                             !contactForm.contactDetEmail.$valid ||
																																							 !contactForm.contactDetMessage.$valid ">
									<span class="glyphicon glyphicon-envelope"></span> &nbsp; Contact us </button>
									<button name="reset" type="button"  style="box-shadow: 3px 3px 10px #252728 ;" ng-click="contactDetEmail = '';  contactDetPhone='';
									   contactDetName =''; contactDetMessage=''; contactForm.$setPristine();"
										class="contactUs resetBtn responsive" value="Reset form" >
										<span class="glyphicon glyphicon-refresh"></span> &nbsp; Reset form </button>
      </form>
    </div>